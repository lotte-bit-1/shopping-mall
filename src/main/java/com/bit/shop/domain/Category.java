package com.bit.shop.domain;

import com.bit.shop.domain.keys.SingleKey;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

<<<<<<< HEAD
=======
@AllArgsConstructor
>>>>>>> fb4a7286ed21c5391567e53eeb62164b85a714db
@Getter
@Builder
public class Category extends BaseEntity<SingleKey<Long>> {

    private String name;
    private int level;
    private Long parentId;
}
