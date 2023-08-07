package com.bit.shop.dao;

import com.bit.shop.domain.Category;
import com.bit.shop.domain.keys.SingleKey;
import java.util.List;
import java.util.Optional;

public class CategoryRepository implements DaoFrame<SingleKey<Long>, Category>{

  @Override
  public Optional<Category> getById(SingleKey<Long> key) {
    return Optional.empty();
  }

  @Override
  public List<Category> getAll() {
    return null;
  }

  @Override
  public void insert(Category object) {

  }

  @Override
  public void delete(SingleKey<Long> key) {

  }

  @Override
  public void update(Category object) {

  }
}
