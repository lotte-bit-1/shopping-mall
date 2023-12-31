package com.bit.shop.service.impl;

import com.bit.shop.dao.CouponRepository;
import com.bit.shop.domain.Coupon;
import com.bit.shop.domain.keys.SingleKey;
import com.bit.shop.service.CouponService;
import com.bit.shop.type.CouponPolicy;

import java.util.List;

public class CouponServiceImpl implements CouponService {
    CouponRepository repository;
    private static CouponServiceImpl couponService;

    public static CouponServiceImpl getInstance() {
        if (couponService == null) return new CouponServiceImpl();
        return couponService;
    }


    private CouponServiceImpl() {
        repository = CouponRepository.getInstance();
    }

    public List<Coupon> getAllCoupon() throws Exception {
        return repository.getAll();
    }

    public void setCouponUsed(Long key) throws Exception {
        repository.delete(new SingleKey<>(key));
    }

    @Override
    public void createCoupon(Long userId) throws Exception {
        repository.insert(Coupon.builder()
                .name("welcome coupon")
                .memberId(userId)
                .discountPolicy(CouponPolicy.PERCENT.toString())
                .discountValue(5)
                .isUsed(false)
                .build());
    }

    @Override
    public void useCoupon(String name, Long userId) throws Exception {
        repository.update(Coupon.builder()
                .name(name)
                .memberId(userId)
                .build());
    }
}
