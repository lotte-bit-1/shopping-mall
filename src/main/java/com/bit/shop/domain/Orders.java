package com.bit.shop.domain;

import com.bit.shop.domain.keys.SingleKey;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

@Getter
@Builder
@RequiredArgsConstructor
public class Orders extends BaseEntity<SingleKey<Long>> {
    private Long id;
    private Long userId;
    private LocalDateTime regDate;
    private String status;
}
