package com.bit.shop.domain;

import com.bit.shop.domain.keys.SingleKey;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
@Builder
public class ProductOrder extends BaseEntity<SingleKey<Long>> {
    private final long productId;
    private final long orderId;
    private final long price;
    private final long quantity;
}
