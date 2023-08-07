package com.bit.shop.util.mapper;

import com.bit.shop.domain.keys.CompositeKey;
import com.bit.shop.util.ConnectionPool;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Map;
import java.util.Map.Entry;

public class CompKeyToPrepareStatementString {

  public static PreparedStatement set(CompositeKey<Long> key, PreparedStatement ps)
      throws SQLException {
    Map<String, Long> map = key.getIdStore();
    Entry<String,Long> entrySet = map.entrySet().iterator().next();
    ps.setString(1,entrySet.getKey());
    ps.setString(2,String.valueOf(entrySet.getValue()));
    return ps;
  }
}
