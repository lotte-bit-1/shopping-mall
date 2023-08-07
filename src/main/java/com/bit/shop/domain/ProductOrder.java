package com.bit.shop.domain;

import com.bit.shop.domain.keys.SingleKey;
import lombok.*;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductOrder extends BaseEntity<SingleKey<Long>> {
    private long productId;
    private long orderId;
    private long price;
    private long quantity;
}
