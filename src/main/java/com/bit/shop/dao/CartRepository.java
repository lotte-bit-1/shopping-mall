package com.bit.shop.dao;

import com.bit.shop.domain.Cart;
import java.util.List;
import java.util.Optional;

public class CartRepository implements DaoFrame<Long, Cart<Long>> {


  @Override
  public Optional<Cart<Long>> getById(Long key) {
    return Optional.empty();
  }

  @Override
  public List<Cart<Long>> getAll() {
    return null;
  }

  @Override
  public void insert(Cart<Long> object) {

  }

  @Override
  public void delete(Long key) {

  }

  @Override
  public void update(Cart<Long> object) {

  }
}
