package com.bit.shop.dao;

import com.bit.shop.domain.Coupon;
import com.bit.shop.domain.keys.SingleKey;
import java.util.List;
import java.util.Optional;

public class CouponRepository implements DaoFrame<SingleKey<Long>, Coupon>{


  @Override
  public Optional<Coupon> getById(SingleKey<Long> key) {
    return Optional.empty();
  }

  @Override
  public List<Coupon> getAll() {
    return null;
  }

  @Override
  public void insert(Coupon object) {

  }

  @Override
  public void delete(SingleKey<Long> key) {

  }

  @Override
  public void update(Coupon object) {

  }
}
