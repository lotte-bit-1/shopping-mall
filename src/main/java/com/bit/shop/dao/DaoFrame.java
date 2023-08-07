package com.bit.shop.dao;

import com.bit.shop.domain.BaseEntity;
import com.bit.shop.domain.keys.EntityKey;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public interface DaoFrame<K extends EntityKey, V extends BaseEntity<K>> {

  Optional<V> getById(K key) throws SQLException, Exception;
  List<V> getAll() throws SQLException, Exception;
  void insert(V object) throws SQLException, Exception;
  void delete(K key) throws SQLException, Exception;
  void update(V object) throws Exception;


  static void close(AutoCloseable ... autoCloseables) {
    for(AutoCloseable autoCloseable : autoCloseables) {
      if(autoCloseable != null) {
        try {
          autoCloseable.close();
        } catch (Exception e) {
          e.printStackTrace();
        }
      }
    }
  }
}
