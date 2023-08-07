package com.bit.shop.domain;

import com.bit.shop.domain.keys.SingleKey;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@AllArgsConstructor
@Getter
@Builder
public class Cart extends BaseEntity<SingleKey<Long>> {

    private int productQuantity;
    private Long productId;
    private Long memberId;

    public void setKey(SingleKey<Long> key) {
        super.key = key;
    }
}
