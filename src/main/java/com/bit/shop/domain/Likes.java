package com.bit.shop.domain;

import com.bit.shop.domain.keys.CompositeKey;
import com.bit.shop.domain.keys.SingleKey;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
@Builder
public class Likes extends BaseEntity<CompositeKey<Long>> {
    private final Long memberId;
    private final Long productId;
}
