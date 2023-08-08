package com.bit.shop.coupon;

import com.bit.shop.service.CouponService;
import com.bit.shop.service.impl.CouponServiceImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CouponUpdateTest {

    @Test
    @DisplayName("coupon service test")
    void update() throws Exception {
        CouponService couponService = new CouponServiceImpl();
        couponService.useCoupon("name", 1L);

    }
}
