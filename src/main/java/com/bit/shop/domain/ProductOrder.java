package com.bit.shop.domain;

import com.bit.shop.domain.keys.SingleKey;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@AllArgsConstructor
@Getter
@Builder
public class ProductOrder extends BaseEntity<SingleKey<Long>> {

    private long productId;
    private String name;
    private int level;
}
