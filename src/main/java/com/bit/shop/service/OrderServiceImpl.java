package com.bit.shop.service;

import com.bit.shop.dao.OrdersRepository;
import com.bit.shop.domain.Cart;
import com.bit.shop.domain.Orders;
import com.bit.shop.domain.keys.SingleKey;
import com.bit.shop.dto.OrdersDto;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class OrderServiceImpl implements OrderService {

    OrdersRepository repository;

    public OrderServiceImpl() {
        repository = new OrdersRepository();
    }

    @Override
    public void register(OrdersDto orders) throws Exception {
        repository.update(
                Orders.builder()
                        .memberId(orders.getMemberId())
                        .status(orders.getStatus())
                        .build()
        );
    }

    @Override
    public void modify(OrdersDto orders) throws Exception {
        repository.update(
                Orders.builder()
                .memberId(orders.getMemberId())
                .status(orders.getStatus())
                .build()
        );
    }

    @Override
    public void remove(SingleKey<Long> key) throws Exception {
        repository.delete(key);
    }

    @Override
    public OrdersDto getOrder(SingleKey<Long> key) throws Exception {
        Optional<Orders> order = repository.getById(key);
        if (order.isEmpty()) {
            throw new Exception("조회할 주문이 없습니다.");
        }
        return new OrdersDto(order.get());
    }

    @Override
    public List<OrdersDto> getAll() throws Exception {
        return repository.getAll().stream().map(OrdersDto::new).collect(Collectors.toList());
    }

    @Override
    public List<OrdersDto> getMembersOrder(Long memberId) throws Exception {
        return repository.getMembersOrder(memberId).stream().map(OrdersDto::new).collect(Collectors.toList());
    }

    @Override
    public void OrderCart(Cart cart) throws Exception {
        OrdersDto orders = OrdersDto.builder()
                .memberId(cart.getMemberId())
                .status("주문")
                .build();

        register(orders);

//        ProductOrder productOrder
    }
}
