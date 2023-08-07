package com.bit.shop.domain;

import com.bit.shop.domain.keys.SingleKey;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Orders extends BaseEntity<SingleKey<Long>> {

    private Long memberId;
    private LocalDateTime regDate;
    private String status;
}
