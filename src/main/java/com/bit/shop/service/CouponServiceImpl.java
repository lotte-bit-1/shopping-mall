package com.bit.shop.service;

import com.bit.shop.dao.CouponRepository;
import com.bit.shop.domain.Coupon;

import java.util.logging.Logger;


public class CouponServiceImpl implements CouponService {
    CouponRepository couponRepository = new CouponRepository();
    Logger log = Logger.getLogger("CouponServiceImpl");

    public void createCoupon(Coupon coupon) throws Exception {
        couponRepository.insert(coupon);
        log.info("insert coupon");
    }


}
