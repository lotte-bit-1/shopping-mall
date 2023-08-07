package com.bit.shop.dto;

import com.bit.shop.domain.BaseEntity;
import com.bit.shop.domain.Orders;
import com.bit.shop.domain.keys.SingleKey;
import lombok.*;

import java.time.LocalDateTime;

@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor(force = false)
public class OrdersDto extends BaseEntity<SingleKey<Long>> {

    private Long memberId;
    private LocalDateTime regDate;
    private String status;

    public OrdersDto(Orders orders) {
        this.memberId = orders.getMemberId();
        this.regDate = orders.getRegDate();
        this.status = orders.getStatus();
    }
}
