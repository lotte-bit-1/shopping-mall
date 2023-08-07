package com.bit.shop.domain;

import com.bit.shop.domain.keys.SingleKey;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;
@Getter
@RequiredArgsConstructor
public class Product extends BaseEntity<SingleKey<Long>> {
    private Long categoryId;
    private String name;
    private long price;
    private int quantity;
    private LocalDateTime regDate;
    private String code;

}
