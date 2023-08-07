package com.bit.shop.service;

import com.bit.shop.dao.CouponRepository;
import com.bit.shop.domain.Coupon;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class CouponServiceImpl implements CouponService {
    private final CouponRepository repository;

    public List<Coupon> getAllCoupon() throws Exception {
        return repository.getAll();
    }


}
