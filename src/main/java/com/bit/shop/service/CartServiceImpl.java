package com.bit.shop.service;

import com.bit.shop.dao.CartRepository;
import com.bit.shop.domain.Cart;
import com.bit.shop.domain.keys.SingleKey;

import java.util.List;
import java.util.Optional;

public class CartServiceImpl implements CartService {

    private CartRepository cartRepository;

    public CartServiceImpl(CartRepository cartRepository) {
        this.cartRepository = cartRepository;
    }

    @Override
    public void register(Cart cart) throws Exception {
        cartRepository.insert(cart);
    }

    @Override
    public Cart getById(Long id) throws Exception {
        SingleKey<Long> key = new SingleKey<>(id);
        Optional<Cart> optionalCart = cartRepository.getById(key);
        if(optionalCart.isEmpty()) {
            throw new Exception("해당 장바구니는 존재하지 않습니다");
        }
        return optionalCart.get();
    }

    @Override
    public List<Cart> getAllByMemberId(Long memberId) throws Exception {
        return cartRepository.getAllByMemberId(memberId);
    }

    @Override
    public void modifyProductQuantityById(Long id, int productQuantity) throws Exception {
        SingleKey<Long> key = new SingleKey<>(id);
        cartRepository.updateProductQuantityById(key, productQuantity);
    }

    @Override
    public void remove(SingleKey<Long> key) throws Exception {
        cartRepository.delete(key);
    }

    @Override
    public void removeAllByMemberId(Long memberId) throws Exception {
        SingleKey<Long> memberKey = new SingleKey<>(memberId);
        cartRepository.deleteAllByMemberKey(memberKey);
    }
}
