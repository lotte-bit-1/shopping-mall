package com.bit.shop.domain;

import com.bit.shop.domain.keys.CompositeKey;
import com.bit.shop.domain.keys.SingleKey;
import lombok.*;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Likes extends BaseEntity<CompositeKey<Long>> {
    private Long memberId;
    private Long productId;
}
