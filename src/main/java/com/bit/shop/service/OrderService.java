package com.bit.shop.service;

import com.bit.shop.domain.Orders;
import com.bit.shop.domain.keys.SingleKey;

import java.util.List;

public interface OrderService {
    public void register(Orders orders) throws Exception;
    public void modify(Orders orders) throws Exception;
    public void remove(SingleKey<Long> key) throws Exception;
    public Orders getOrder(SingleKey<Long> key) throws Exception;
    public List<Orders> getAll() throws Exception;
    public List<Orders> getMembersOrder(Long memberId) throws Exception;
}
