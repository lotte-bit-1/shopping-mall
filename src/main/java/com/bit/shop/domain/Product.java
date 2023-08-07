package com.bit.shop.domain;

import com.bit.shop.domain.keys.SingleKey;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;
@Builder
@Getter
@RequiredArgsConstructor
public class Product extends BaseEntity<SingleKey<Long>> {
    private final Long categoryId;
    private final String name;
    private final long price;
    private final int quantity;
    private final LocalDateTime regDate;
    private final String code;

}
