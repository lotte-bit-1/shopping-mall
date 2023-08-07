package com.bit.shop.service;

import com.bit.shop.domain.Cart;
import com.bit.shop.domain.keys.SingleKey;

import java.util.List;

public interface CartService {

    void register(Cart cart) throws Exception;
    Cart getById(Long id) throws Exception;
    List<Cart> getAllByMemberId(Long memberId) throws Exception;
    void modifyProductQuantityById(Long id, int productQuantity) throws Exception;
    void remove(SingleKey<Long> key) throws Exception;
    void removeAllByMemberId(Long memberId) throws Exception;
}
