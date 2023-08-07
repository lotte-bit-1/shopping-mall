package com.bit.shop.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@AllArgsConstructor
@Getter
@Builder
public class CouponDTO {
    private Long id;
    private Long memberId;
    private String name;
    private String discountPolicy;
    private int discountValue;
    private boolean isUsed;
}
