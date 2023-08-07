package com.bit.shop.service;

import com.bit.shop.dao.OrdersRepository;
import com.bit.shop.domain.Orders;
import com.bit.shop.domain.keys.SingleKey;

import java.util.List;
import java.util.Optional;

public class OrderServiceImpl implements OrderService {

    OrdersRepository repository;

    public OrderServiceImpl() {
        repository = new OrdersRepository();
    }

    @Override
    public void register(Orders orders) throws Exception {
        repository.insert(orders);
    }

    @Override
    public void modify(Orders orders) throws Exception {
        repository.update(orders);
    }

    @Override
    public void remove(SingleKey<Long> key) throws Exception {
        repository.delete(key);
    }

    @Override
    public Orders getOrder(SingleKey<Long> key) throws Exception {
        Optional<Orders> order = repository.getById(key);
        if (order.isEmpty()) {
            throw new Exception("조회할 주문이 없습니다.");
        }
        return order.get();
    }

    @Override
    public List<Orders> getAll() throws Exception {
        return repository.getAll();
    }

    @Override
    public List<Orders> getMembersOrder(Long memberId) throws Exception {
        return repository.getMembersOrder(memberId);
    }
}
