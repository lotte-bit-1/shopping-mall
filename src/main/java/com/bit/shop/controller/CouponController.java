package com.bit.shop.controller;

import com.bit.shop.domain.Coupon;
import com.bit.shop.dto.CouponTypeDto;
import com.bit.shop.service.CouponService;
import com.bit.shop.service.CouponServiceImpl;

import java.util.ArrayList;
import java.util.List;


public class CouponController {
    CouponService couponService;

    public CouponController() {
        couponService = new CouponServiceImpl();
    }

    public void giveCoupon(Long userId) throws Exception {
        couponService.createCoupon(userId);
    }

    public void useCoupon(String name,  Long userId) throws Exception {
        couponService.useCoupon(name, userId);
    }

    public void getMyCoupon(Long userId) throws Exception {
        List<Coupon> allCoupon = couponService.getAllCoupon();
        List<Coupon> my = new ArrayList<>();
        for (Coupon c :
                allCoupon) {
            if (c.getMemberId().equals(userId) && !c.isUsed()) {
                my.add(c);
            }
        }
        for (Coupon c :
                my) {
            System.out.println("coupon id: " + c.getName());
        }
    }

    public CouponTypeDto getCouponTypeAndValue(String couponName, Long userId) throws Exception {
        List<Coupon> allCoupon = couponService.getAllCoupon();
        for (Coupon c :
                allCoupon) {
            if (c.getName().equals(couponName) && c.getMemberId().equals(userId)) {
                return CouponTypeDto.builder()
                        .discountValue(c.getDiscountValue())
                        .discountPolicy(c.getDiscountPolicy())
                        .build();
            }
        }
        return null;
    }
}
