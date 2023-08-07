package com.bit.shop.dto;

import com.bit.shop.domain.Cart;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CartDto {
    private int productQuantity;
    private Long productId;
    private Long memberId;

    public CartDto(Cart cart) {
        this.productQuantity = cart.getProductQuantity();
        this.productId = cart.getProductId();
        this.memberId = cart.getMemberId();
    }
}
