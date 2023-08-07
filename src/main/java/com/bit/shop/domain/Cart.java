package com.bit.shop.domain;

import com.bit.shop.domain.keys.SingleKey;
import lombok.*;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Cart extends BaseEntity<SingleKey<Long>> {

    private int productQuantity;
    private Long productId;
    private Long memberId;
}
