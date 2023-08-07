package com.bit.shop.domain;

import com.bit.shop.domain.keys.SingleKey;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Builder
@Getter
@RequiredArgsConstructor
@Builder
public class ProductOrder extends BaseEntity<SingleKey<Long>> {
    private final long parentId;
    private final String name;
    private final int level;

}
