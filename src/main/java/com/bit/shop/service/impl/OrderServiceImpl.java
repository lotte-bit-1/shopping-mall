package com.bit.shop.service.impl;

import com.bit.shop.dao.OrdersRepository;
import com.bit.shop.dao.ProductOrderRepository;
import com.bit.shop.dao.ProductRepository;
import com.bit.shop.domain.Orders;
import com.bit.shop.domain.ProductOrder;
import com.bit.shop.domain.keys.SingleKey;
import com.bit.shop.dto.CartDto;
import com.bit.shop.dto.OrdersDto;
import com.bit.shop.dto.ProductDto;
import com.bit.shop.service.OrderService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class OrderServiceImpl implements OrderService {

    OrdersRepository ordersRepository;
    ProductRepository productRepository;
    ProductOrderRepository productOrderRepository;

    public OrderServiceImpl() {
        ordersRepository = new OrdersRepository();
        productRepository = new ProductRepository();
        productOrderRepository = new ProductOrderRepository();
    }

    @Override
    public void register(OrdersDto orders) throws Exception {
        ordersRepository.insert(
                Orders.builder()
                        .memberId(orders.getMemberId())
                        .status(orders.getStatus())
                        .build()
        );
    }

    @Override
    public void modify(OrdersDto orders) throws Exception {
        ordersRepository.update(
                Orders.builder()
                .memberId(orders.getMemberId())
                .status(orders.getStatus())
                .build()
        );
    }

    @Override
    public void remove(SingleKey<Long> key) throws Exception {
        ordersRepository.delete(key);
    }

    @Override
    public void removeAll() throws Exception {
        ordersRepository.deleteAll();
    }

    @Override
    public OrdersDto getOrder(SingleKey<Long> key) throws Exception {
        Optional<Orders> order = ordersRepository.getById(key);
        if (order.isEmpty()) {
            throw new Exception("조회할 주문이 없습니다.");
        }
        return new OrdersDto(order.get());
    }

    @Override
    public List<OrdersDto> getAll() throws Exception {
        return ordersRepository.getAll().stream().map(OrdersDto::new).collect(Collectors.toList());
    }

    @Override
    public List<OrdersDto> getMembersOrder(Long memberId) throws Exception {
        return ordersRepository.getMembersOrder(memberId).stream().map(OrdersDto::new).collect(Collectors.toList());
    }

    @Override
    public Long makeOrder(Long memberId) throws Exception {
        Orders orders = Orders.builder()
                .memberId(memberId)
                .status("주문")
                .build();

        return ordersRepository.insertAndGet(orders);
    }

    @Override
    public Long orderCart(List<CartDto> cartDtoList) throws Exception {
        Long ordersId = makeOrder(cartDtoList.get(0).getMemberId());
        Long totalPrice = 0L;

        for (CartDto cart : cartDtoList) {
            long price = productRepository.getById(new SingleKey<Long>(cart.getProductId())).get().getPrice();
//            long price = 10L;
            long productId = cart.getProductId();
            long quantity = cart.getProductQuantity();

            ProductOrder productOrder = ProductOrder.builder()
                    .orderId(ordersId)
                    .productId(productId)
                    .quantity(quantity)
                    .price(price)
                    .build();

            totalPrice += price * quantity;
            productOrderRepository.insert(productOrder);
        }

        return totalPrice;
    }

    @Override
    public Long orderProduct(ProductDto product, Long memberId) throws Exception {
        Long ordersId = makeOrder(memberId);
        long price = product.getPrice();
        long quantity = product.getQuantity();

        // Unique인 코드값으로 ID PK 조회
        productOrderRepository.insert(
                ProductOrder.builder()
                        .orderId(ordersId)
//                        .productId(productRepository.getByCode(product.getCode())))
                        .quantity(quantity)
                        .price(price)
                .build()
        );

        return price * quantity;
    }

}
