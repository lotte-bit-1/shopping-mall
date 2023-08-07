package com.bit.shop.service;

import com.bit.shop.domain.Cart;
import com.bit.shop.domain.Orders;
import com.bit.shop.domain.keys.SingleKey;
import com.bit.shop.dto.OrdersDto;

import java.util.List;

public interface OrderService {
    public void register(OrdersDto orders) throws Exception;
    public void modify(OrdersDto orders) throws Exception;
    public void remove(SingleKey<Long> key) throws Exception;
    public OrdersDto getOrder(SingleKey<Long> key) throws Exception;
    public List<OrdersDto> getAll() throws Exception;
    public List<OrdersDto> getMembersOrder(Long memberId) throws Exception;
    public void OrderCart(Cart cart) throws Exception;
}
