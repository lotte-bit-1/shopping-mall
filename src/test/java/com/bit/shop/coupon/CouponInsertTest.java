package com.bit.shop.coupon;

import com.bit.shop.dao.CouponRepository;
import com.bit.shop.domain.Coupon;
import com.bit.shop.domain.keys.SingleKey;
import com.bit.shop.service.CouponService;
import com.bit.shop.service.impl.CouponServiceImpl;
import com.bit.shop.type.CouponPolicy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.logging.Logger;

public class CouponInsertTest {
    Logger log = Logger.getLogger("CouponInsertTest");


    @Test
    @DisplayName("coupon service test")
    void update() throws Exception {
        CouponService couponService = new CouponServiceImpl();
        couponService.useCoupon("name", 1L);

    }

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

    @Test
    @DisplayName("coupon select test")
    void select() throws Exception {
        CouponRepository couponRepository = new CouponRepository();
        List<Coupon> all = couponRepository.getAll();
        log.info(all.get(0).getName());
        log.info("select all success");
    }

    @Test
    @DisplayName("coupon select test")
    void delete() throws Exception {
        CouponRepository couponRepository = new CouponRepository();
        couponRepository.delete(new SingleKey<>(2L));
        log.info("select all success");
    }
}
