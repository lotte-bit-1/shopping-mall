package com.bit.shop.domain;

import com.bit.shop.domain.keys.SingleKey;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class Cart extends BaseEntity<SingleKey<Long>> {

    private final int productQuantity;
    private final Long productId;
    private final Long memberId;
}
