package com.bit.shop.domain;

import com.bit.shop.domain.keys.SingleKey;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class ProductOrder extends BaseEntity<SingleKey<Long>> {
    private long parentId;
    private String name;
    private int level;

}
