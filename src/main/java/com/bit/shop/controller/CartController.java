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
            log.warning(e.getMessage());
        }

        log.info("장바구니에 상품 추가");
    }

    public GetCartResponse get(Long id) {
        Cart cart = null;
        try {
            if(id == null) {
                throw new IllegalArgumentException("해당 장바구니의 상품은 존재하지 않습니다");
            }

            cart = cartService.getById(id);
        } catch (Exception e) {
            log.warning(e.getMessage());
        }

        log.info("장바구니의 특정 상품 조회");

        return GetCartResponse.builder()
                .memberId(cart.getMemberId())
                .productId(cart.getProductId())
                .productQuantity(cart.getProductQuantity())
                .build();
    }

    public List<GetCartResponse> getAll(Long memberId) {
        List<Cart> carts = null;
        try {
            if(memberId == null) {
                throw new IllegalArgumentException("로그인이 필요한 서비스입니다");
            }

            carts = cartService.getAllByMemberId(memberId);
        } catch (Exception e) {
            log.warning(e.getMessage());
        }

        log.info("장바구니의 모든 상품 조회");

        return carts.stream().map(c -> GetCartResponse.builder()
                .memberId(c.getMemberId())
                .productId(c.getProductId())
                .productQuantity(c.getProductQuantity())
                .build()).collect(Collectors.toList());
    }

    public void modifyProductQuantity(Long id, ModifyCartRequest cartModifyRequestDto) {
        try {
            if(id == null) {
                throw new IllegalArgumentException("해당 장바구니의 상품은 존재하지 않습니다");
            }
            if(cartModifyRequestDto.getProductQuantity() == 0) {
                throw new IllegalArgumentException("상품 수량은 0보다 커야합니다");
            }

            cartService.modifyProductQuantityById(id, cartModifyRequestDto.getProductQuantity());
        } catch (Exception e) {
            log.warning(e.getMessage());
        }

        log.info("장바구니의 특정 상품의 수량 수정 완료");
    }

    public void remove(Long id) {
        try {
            if(id == null) {
                throw new IllegalArgumentException("해당 장바구니의 상품은 존재하지 않습니다");
            }

            cartService.remove(new SingleKey<>(id));
        } catch (Exception e) {
            log.warning(e.getMessage());
        }

        log.info("장바구니의 상품 하나 삭제 완료");
    }

    public void removeAll(Long memberId) {
        try {
            if(memberId == null) {
                throw new IllegalArgumentException("로그인이 필요한 서비스입니다");
            }

            cartService.removeAllByMemberId(memberId);
        } catch (Exception e) {
            log.warning(e.getMessage());
        }

        log.info("장바구니의 모든 상품 삭제 완료");
    }
}
