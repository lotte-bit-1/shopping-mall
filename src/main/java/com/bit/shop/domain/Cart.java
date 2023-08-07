package com.bit.shop.domain;

import com.bit.shop.domain.keys.SingleKey;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Builder
@Getter
@RequiredArgsConstructor
public class Cart extends BaseEntity<SingleKey<Long>> {

    private final int productQuantity;
    private final Long productId;
    private final Long memberId;
}
