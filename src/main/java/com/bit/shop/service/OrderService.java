package com.bit.shop.service;

import com.bit.shop.domain.Cart;
import com.bit.shop.domain.Orders;
import com.bit.shop.domain.Product;
import com.bit.shop.domain.keys.SingleKey;
import com.bit.shop.dto.CartDto;
import com.bit.shop.dto.OrdersDto;
import com.bit.shop.dto.ProductDto;

import java.util.List;

public interface OrderService {
    public void register(OrdersDto orders) throws Exception;
    public void modify(OrdersDto orders) throws Exception;
    public void remove(SingleKey<Long> key) throws Exception;
    public void removeAll() throws Exception;
    public OrdersDto getOrder(SingleKey<Long> key) throws Exception;
    public List<OrdersDto> getAll() throws Exception;
    public List<OrdersDto> getMembersOrder(Long memberId) throws Exception;
    public Long makeOrder(Long memberId) throws Exception;
    public Long orderCart(List<CartDto> cartDtoList) throws Exception;
    public Long orderProduct(ProductDto product, Long memberId) throws Exception;
}
