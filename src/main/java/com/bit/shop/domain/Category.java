package com.bit.shop.domain;

import com.bit.shop.domain.keys.SingleKey;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
public class Category extends BaseEntity<SingleKey<Long>> {

    private String name;
    private int level;
    private Long parentId;
}
