package com.bit.shop.dao;

import com.bit.shop.domain.BaseEntity;
import java.util.List;
import java.util.Optional;

public interface DaoFrame<K extends Long,V extends BaseEntity<Long>> {

  public Optional<V> getById(K key);
  public List<V> getAll();
  public void insert(V object);
  public void delete(K key);
  public void update(V object);
}
