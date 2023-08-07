package com.bit.shop.domain;

import com.bit.shop.domain.keys.SingleKey;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
@Builder
public class ProductOrder extends BaseEntity<SingleKey<Long>> {
    private long parentId;
    private String name;
    private int level;

}
