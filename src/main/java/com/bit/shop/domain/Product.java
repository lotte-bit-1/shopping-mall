package com.bit.shop.domain;

import com.bit.shop.domain.keys.SingleKey;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@AllArgsConstructor
@Getter
<<<<<<< HEAD
@RequiredArgsConstructor
=======
@Builder
>>>>>>> fb4a7286ed21c5391567e53eeb62164b85a714db
public class Product extends BaseEntity<SingleKey<Long>> {
    private Long categoryId;
    private String name;
    private long price;
    private int quantity;
    private LocalDateTime regDate;
    private String code;


}
