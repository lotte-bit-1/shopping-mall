package com.bit.shop.service;

import com.bit.shop.dao.CouponRepository;
import com.bit.shop.domain.Coupon;
import com.bit.shop.domain.keys.SingleKey;

import java.util.List;

public class CouponServiceImpl implements CouponService {
    CouponRepository repository;

    public CouponServiceImpl() {
        repository = new CouponRepository();
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
                .discountPolicy("percent")
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
