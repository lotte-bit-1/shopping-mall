package com.bit.shop.dao;

import com.bit.shop.domain.BaseEntity;
import com.bit.shop.domain.keys.EntityKey;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public interface DaoFrame<K extends EntityKey, V extends BaseEntity<K>> {

<<<<<<< HEAD
  Optional<V> getById(K key) throws SQLException;
  List<V> getAll() throws SQLException;
  void insert(V object) throws SQLException;
  void delete(K key) throws SQLException;
  void update(V object);
=======

  Optional<V> getById(K key) throws Exception;
  List<V> getAll() throws Exception;
  void insert(V object) throws Exception;
  void delete(K key) throws Exception;
  void update(V object) throws Exception;
>>>>>>> fb4a7286ed21c5391567e53eeb62164b85a714db

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
