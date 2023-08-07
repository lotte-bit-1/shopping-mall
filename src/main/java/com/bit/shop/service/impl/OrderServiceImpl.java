package com.bit.shop.service.impl;

import com.bit.shop.dao.OrdersRepository;
import com.bit.shop.dao.ProductOrderRepository;
import com.bit.shop.dao.ProductRepository;
import com.bit.shop.domain.Orders;
import com.bit.shop.domain.ProductOrder;
import com.bit.shop.domain.keys.SingleKey;
import com.bit.shop.dto.*;
import com.bit.shop.service.CouponService;
import com.bit.shop.service.OrderService;
import com.bit.shop.type.CouponPolicy;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class OrderServiceImpl implements OrderService {

    OrdersRepository ordersRepository;
    ProductRepository productRepository;
    ProductOrderRepository productOrderRepository;
    CouponService couponService;

    public OrderServiceImpl() {
        ordersRepository = new OrdersRepository();
        productRepository = new ProductRepository();
        productOrderRepository = new ProductOrderRepository();
        couponService = new CouponServiceImpl();
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

    public void cancelOrder(SingleKey<Long> key) throws Exception {
        Orders orders = ordersRepository.getById(key).orElseThrow();
        if (orders.getStatus().equals("주문")) {
            ordersRepository.update(
                    Orders.builder()
                            .memberId(orders.getMemberId())
                            .status("주문 취소")
                            .build()
            );
        } else {
            throw new Exception("주문 중인 정보가 없음");
        }
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
    public Long orderCart(List<OrderCartDto> orderCartDtoList) throws Exception {
        Long ordersId = makeOrder(orderCartDtoList.get(0).getMemberId());
        Long totalPrice = 0L;

        for (OrderCartDto cart : orderCartDtoList) {
//            long price = productRepository.getById(new SingleKey<Long>(cart.getProductId())).get().getPrice();
            long price = 10L;

            // 쿠폰이 있을 시 할인적용
            if (cart.getCouponTypeDto() != null) {
                price = discount(price, cart.getCouponTypeDto());
            }

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
    public Long orderProduct(OrderProductDto orderProductDto) throws Exception {
        Long ordersId = makeOrder(orderProductDto.getMemberId());
        long price = orderProductDto.getPrice();
        long quantity = orderProductDto.getQuantity();

        // 쿠폰이 있을 시 할인적용
        if (orderProductDto.getCouponTypeDto() != null) {
            price = discount(price, orderProductDto.getCouponTypeDto());
        }

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

    
    // 쿠폰 할인
    public Long discount(long price, CouponTypeDto couponTypeDto) {
        // 쿠폰 타입이 %인지, 금액인지에 따라 할인
        if (couponTypeDto.getDiscountPolicy().equals(CouponPolicy.PERCENT.toString())) {
            price *= couponTypeDto.getDiscountValue();
        } else {
            price -= couponTypeDto.getDiscountValue();
        }

        return price > 0 ? price : 0;
    }

}
