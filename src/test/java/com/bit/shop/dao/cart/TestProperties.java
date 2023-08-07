package com.bit.shop.dao.cart;

import com.bit.shop.domain.keys.SingleKey;

public interface TestProperties {
    SingleKey<Long> memberKey = new SingleKey<>(1L);
    SingleKey<Long> productKey = new SingleKey<>(1L);
}
