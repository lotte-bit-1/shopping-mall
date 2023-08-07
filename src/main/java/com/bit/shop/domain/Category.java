package com.bit.shop.domain;

import com.bit.shop.domain.keys.SingleKey;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class Category extends BaseEntity<SingleKey<Long>> {

    private final String name;
    private final int level;
    private Long parentId;
}
