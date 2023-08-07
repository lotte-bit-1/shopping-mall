package com.bit.shop.dao;

import com.bit.shop.domain.BaseEntity;
import com.bit.shop.domain.Cart;
import com.bit.shop.domain.Member;
import com.bit.shop.domain.keys.EntityKey;
import com.bit.shop.domain.keys.SingleKey;
import java.util.List;
import java.util.Optional;

public class MemberRepository implements DaoFrame<SingleKey<Long>, Member> {


  @Override
  public Optional<Member> getById(SingleKey<Long> key) {
    return Optional.empty();
  }

  @Override
  public List<Member> getAll() {
    return null;
  }

  @Override
  public void insert(Member object) {

  }

  @Override
  public void delete(SingleKey<Long> key) {

  }

  @Override
  public void update(Member object) {

  }
}
