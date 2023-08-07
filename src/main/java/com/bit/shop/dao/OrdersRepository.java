package com.bit.shop.dao;

import com.bit.shop.domain.BaseEntity;
import com.bit.shop.domain.Orders;
import com.bit.shop.domain.keys.EntityKey;
import com.bit.shop.domain.keys.SingleKey;
import com.mysql.cj.x.protobuf.MysqlxCrud.Order;
import java.util.List;
import java.util.Optional;

public class OrdersRepository implements DaoFrame<SingleKey<Long>, Orders>{


  @Override
  public Optional<Orders> getById(SingleKey<Long> key) {
    return Optional.empty();
  }

  @Override
  public List<Orders> getAll() {
    return null;
  }

  @Override
  public void insert(Orders object) {

  }

  @Override
  public void delete(SingleKey<Long> key) {

  }

  @Override
  public void update(Orders object) {

  }
}
