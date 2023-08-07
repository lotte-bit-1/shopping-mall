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
public class OrderCartDto {
    private int productQuantity;
    private Long productId;
    private Long memberId;
    private CouponTypeDto couponTypeDto;

    public OrderCartDto(Cart cart) {
        this.productQuantity = cart.getProductQuantity();
        this.productId = cart.getProductId();
        this.memberId = cart.getMemberId();
    }

}
