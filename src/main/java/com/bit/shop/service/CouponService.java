package com.bit.shop.service;

import com.bit.shop.domain.Coupon;

import java.util.List;

public interface CouponService {
    List<Coupon> getAllCoupon() throws Exception;

    void setCouponUsed(Long key) throws Exception;

    void createCoupon(Long userId) throws Exception;

    void useCoupon(String name, Long userId) throws Exception;
}
