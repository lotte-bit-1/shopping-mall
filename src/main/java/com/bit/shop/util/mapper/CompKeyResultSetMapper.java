package com.bit.shop.util.mapper;

import com.bit.shop.domain.BaseEntity;
import com.bit.shop.domain.keys.CompositeKey;
import com.bit.shop.domain.keys.EntityKey;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public interface CompKeyResultSetMapper<T extends BaseEntity<CompositeKey<Long>>>{
  public List<T> convert(ResultSet resultSet) throws SQLException;
}
