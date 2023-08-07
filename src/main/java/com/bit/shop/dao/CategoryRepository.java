package com.bit.shop.dao;

import com.bit.shop.domain.Category;
import com.bit.shop.domain.keys.SingleKey;
import com.bit.shop.util.ConnectionPool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

public class CategoryRepository implements DaoFrame<SingleKey<Long>, Category>{

  Logger log = Logger.getLogger("CategoryRepository");
  ConnectionPool cp;

  public CategoryRepository() {
    try {
      cp = ConnectionPool.create();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  @Override
  public Optional<Category> getById(SingleKey<Long> key) throws Exception {
    return Optional.empty();
  }

  @Override
  public List<Category> getAll() throws Exception {
    Connection con = cp.getConnection();
    PreparedStatement pstmt = null;
    ResultSet rset = null;

    List<Category> categories = new ArrayList<>();
    try {
      final String query = "SELECT * FROM category";
      pstmt = con.prepareStatement(query);
      rset = pstmt.executeQuery();
      while(rset.next()) {
        Category category = Category.builder()
                .parentId(rset.getLong("parent_id"))
                .name(rset.getString("name"))
                .level(rset.getInt("level"))
                .build();
        category.setKey(new SingleKey<>(rset.getLong("id")));
        categories.add(category);

      }
    } catch(Exception e) {
      log.info(e.getMessage());
      throw new Exception("런타임 에러");
    } finally {
      // close db resources
      DaoFrame.close(pstmt);
      cp.releaseConnection(con);
    }

    return categories;
  }

  public List<Category> getAllWithById(SingleKey<Long> key) throws Exception {
    Connection con = cp.getConnection();
    PreparedStatement pstmt = null;
    ResultSet rset = null;

    List<Category> categories = new ArrayList<>();
    try {
      final String query = "SELECT c1.id AS category_id, c1.parent_id, c1.name, c1.level " +
              "FROM category c1 " +
              "WHERE c1.id = ? " +
              "UNION " +
              "SELECT distinct c2.id AS category_id, c2.parent_id, c2.name, c2.level " +
              "FROM category c1 " +
              "JOIN category c2 ON c2.id = c1.parent_id " +
              "WHERE c1.id = ? " +
              "UNION " +
              "SELECT c3.id AS category_id, c3.parent_id, c3.name, c3.level " +
              "FROM category c1 " +
              "JOIN category c2 ON c2.id = c1.parent_id " +
              "JOIN category c3 ON c3.id = c2.parent_id " +
              "WHERE c1.id = ?";
      pstmt = con.prepareStatement(query);
      pstmt.setLong(1, key.getId());
      pstmt.setLong(2, key.getId());
      pstmt.setLong(3, key.getId());
      rset = pstmt.executeQuery();
      while(rset.next()) {
        Category category = Category.builder()
                .parentId(rset.getLong("parent_id"))
                .name(rset.getString("name"))
                .level(rset.getInt("level"))
                .build();
        category.setKey(new SingleKey<>(rset.getLong("category_id")));
        categories.add(category);

      }
    } catch(Exception e) {
      log.info(e.getMessage());
      throw new Exception("런타임 에러");
    } finally {
      // close db resources
      DaoFrame.close(pstmt);
      cp.releaseConnection(con);
    }

    return categories;
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
