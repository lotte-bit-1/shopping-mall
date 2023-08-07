package com.bit.shop.controller;

import com.bit.shop.domain.Cart;
import com.bit.shop.domain.keys.SingleKey;
import com.bit.shop.dto.GetCartResponse;
import com.bit.shop.dto.ModifyCartRequest;
import com.bit.shop.dto.RegisterCartRequest;
import com.bit.shop.service.CartService;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class CartController {

    Logger log = Logger.getLogger("CartController");
    private final CartService cartService;

    public void register(RegisterCartRequest cartRegisterRequest) {
        if(cartRegisterRequest == null) {
            throw new IllegalArgumentException("카트에 넣을 정보가 없습니다");
        }
        if(cartRegisterRequest.getMemberId() == null) {
            throw new IllegalArgumentException("로그인이 필요한 서비스입니다");
        }
        if(cartRegisterRequest.getProductId() == null) {
            throw new IllegalArgumentException("상품을 선택해주세요");
        }
        if(cartRegisterRequest.getProductQuantity() == 0) {
            throw new IllegalArgumentException("상품 수량은 0보다 커야합니다");
        }

        Cart cart = Cart.builder()
                .memberId(cartRegisterRequest.getMemberId())
                .productId(cartRegisterRequest.getProductId())
                .productQuantity(cartRegisterRequest.getProductQuantity())
                .build();

        try {
            cartService.register(cart);
        } catch(Exception e) {
            log.info(e.getMessage());
        }
    }

    public GetCartResponse get(Long id) {
        if(id == null) {
            throw new IllegalArgumentException("해당 장바구니의 상품은 존재하지 않습니다");
        }

        Cart cart = null;
        try {
            cart = cartService.getById(id);
        } catch (Exception e) {
            log.info(e.getMessage());
        }

        return GetCartResponse.builder()
                .memberId(cart.getMemberId())
                .productId(cart.getProductId())
                .productQuantity(cart.getProductQuantity())
                .build();
    }

    public List<GetCartResponse> getAll(Long memberId) {
        if(memberId == null) {
            throw new IllegalArgumentException("로그인이 필요한 서비스입니다");
        }

        List<Cart> carts = null;
        try {
            carts = cartService.getAllByMemberId(memberId);
        } catch (Exception e) {
            log.info(e.getMessage());
        }

        List<GetCartResponse> getCartResponses = carts.stream().map(c -> GetCartResponse.builder()
                .memberId(c.getMemberId())
                .productId(c.getProductId())
                .productQuantity(c.getProductQuantity())
                .build()).collect(Collectors.toList());
        return getCartResponses;
    }

    public void modifyProductQuantity(Long id, ModifyCartRequest cartModifyRequestDto) {
        if(id == null) {
            throw new IllegalArgumentException("해당 장바구니의 상품은 존재하지 않습니다");
        }
        if(cartModifyRequestDto.getProductQuantity() == 0) {
            throw new IllegalArgumentException("상품 수량은 0보다 커야합니다");
        }

        try {
            cartService.modifyProductQuantityById(id, cartModifyRequestDto.getProductQuantity());
        } catch (Exception e) {
            log.info(e.getMessage());
        }
    }

    public void remove(Long id) {
        if(id == null) {
            throw new IllegalArgumentException("해당 장바구니의 상품은 존재하지 않습니다");
        }

        try {
            cartService.remove(new SingleKey<>(id));
        } catch (Exception e) {
            log.info(e.getMessage());
        }
    }

    public void removeAll(Long memberId) {
        if(memberId == null) {
            throw new IllegalArgumentException("로그인이 필요한 서비스입니다");
        }

        try {
            cartService.removeAllByMemberId(memberId);
        } catch (Exception e) {
            log.info(e.getMessage());
        }
    }
}
