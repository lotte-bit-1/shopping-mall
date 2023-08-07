package com.bit.shop.dao;

import com.bit.shop.domain.BaseEntity;
import com.bit.shop.domain.keys.EntityKey;
import java.util.List;
import java.util.Optional;

public class OrdersRepository implements DaoFrame{

  @Override
  public Optional getById(EntityKey key) {
    return Optional.empty();
  }

  @Override
  public List getAll() {
    return null;
  }

  @Override
  public void insert(BaseEntity object) {

  }

  @Override
  public void delete(EntityKey key) {

  }

  @Override
  public void update(BaseEntity object) {

  }
}
