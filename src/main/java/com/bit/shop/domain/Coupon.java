package com.bit.shop.domain;

import com.bit.shop.domain.keys.SingleKey;
import lombok.*;


@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Coupon extends BaseEntity<SingleKey<Long>> {
    private Long memberId;
    private String name;
    private String discountPolicy;
    private int discountValue;
    private boolean isUsed;
}
