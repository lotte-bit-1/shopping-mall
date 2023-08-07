package com.bit.shop.domain;

import com.bit.shop.domain.keys.SingleKey;
import lombok.*;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Category extends BaseEntity<SingleKey<Long>> {

    private String name;
    private int level;
    private Long parentId;
}
