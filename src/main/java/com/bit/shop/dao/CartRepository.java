package com.bit.shop.dao;

import com.bit.shop.domain.Cart;
import com.bit.shop.domain.keys.SingleKey;
import java.util.List;
import java.util.Optional;

public class CartRepository implements DaoFrame<SingleKey<Long>, Cart> {

  @Override
  public Optional<Cart> getById(SingleKey<Long> key) {
    return Optional.empty();
  }

  @Override
  public List<Cart> getAll() {
    return null;
  }

  @Override
  public void insert(Cart object) {

  }

  @Override
  public void delete(SingleKey<Long> key) {

  }

  @Override
  public void update(Cart object) {

  }
}
