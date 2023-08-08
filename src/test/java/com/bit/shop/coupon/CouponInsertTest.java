package com.bit.shop.coupon;

import com.bit.shop.dao.CouponRepository;
import com.bit.shop.domain.Coupon;
import com.bit.shop.type.CouponPolicy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.logging.Logger;

public class CouponInsertTest {
    Logger log = Logger.getLogger("CouponInsertTest");

    @Test
    @DisplayName("coupon insert test")
    void insert() throws Exception {
        CouponRepository couponRepository = new CouponRepository();
        couponRepository.insert(Coupon.builder()
                .memberId(1L)
                .name("name5")
                .isUsed(true)
                .discountPolicy(CouponPolicy.VOUCHER.toString())
                .discountValue(9000)
                .build());
    }


}
