package com.bit.shop.domain;

import com.bit.shop.domain.keys.SingleKey;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
@Builder
public class Coupon extends BaseEntity<SingleKey<Long>> {
    private final Long memberId;
    private final String name;
    private final String discountPolicy;
    private final int discountValue;
    private final boolean isUsed;
}
