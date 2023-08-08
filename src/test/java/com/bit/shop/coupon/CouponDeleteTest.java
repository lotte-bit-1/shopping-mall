package com.bit.shop.coupon;

import com.bit.shop.dao.CouponRepository;
import com.bit.shop.domain.keys.SingleKey;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.logging.Logger;

public class CouponDeleteTest {
    Logger log = Logger.getLogger("CouponInsertTest");

    @Test
    @DisplayName("coupon select test")
    void delete() throws Exception {
        CouponRepository couponRepository = new CouponRepository();
        couponRepository.delete(new SingleKey<>(2L));
        log.info("select all success");
    }
}
