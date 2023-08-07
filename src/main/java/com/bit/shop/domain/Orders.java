package com.bit.shop.domain;

import com.bit.shop.domain.keys.SingleKey;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@Getter
@Builder
public class Orders extends BaseEntity<SingleKey<Long>> {

    private Long userId;
    private LocalDateTime regDate;
    private String status;
}
