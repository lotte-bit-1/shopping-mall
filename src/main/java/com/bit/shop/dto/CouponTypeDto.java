package com.bit.shop.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class CouponTypeDto {
    private String discountPolicy;
    private int discountValue;
}
