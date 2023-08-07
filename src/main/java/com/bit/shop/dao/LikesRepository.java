package com.bit.shop.dao;

import com.bit.shop.domain.BaseEntity;
import com.bit.shop.domain.Likes;
import com.bit.shop.domain.keys.CompositeKey;
import com.bit.shop.domain.keys.EntityKey;
import java.util.List;
import java.util.Optional;

public class LikesRepository implements DaoFrame<CompositeKey<Long>, Likes> {


  @Override
  public Optional<Likes> getById(CompositeKey<Long> key) {
    return Optional.empty();
  }

  @Override
  public List<Likes> getAll() {
    return null;
  }

  @Override
  public void insert(Likes object) {

  }

  @Override
  public void delete(CompositeKey<Long> key) {

  }

  @Override
  public void update(Likes object) {

  }
}
