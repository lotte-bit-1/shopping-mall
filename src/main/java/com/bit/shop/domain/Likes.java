package com.bit.shop.domain;

import com.bit.shop.domain.keys.CompositeKey;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@AllArgsConstructor
@Getter
@Builder
public class Likes extends BaseEntity<CompositeKey<Long>> {
    private Long memberId;
    private Long productId;
}
