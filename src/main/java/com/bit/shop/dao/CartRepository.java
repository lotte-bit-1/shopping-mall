package com.bit.shop.dao;

import com.bit.shop.domain.Cart;
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

public class CartRepository implements DaoFrame<SingleKey<Long>, Cart> {

  Logger log = Logger.getLogger("CartRepository");
  ConnectionPool cp;

  public CartRepository() {
    try {
      cp = ConnectionPool.create();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  @Override
  public Optional<Cart> getById(SingleKey<Long> key) throws Exception {
    Connection con = cp.getConnection();
    PreparedStatement pstmt = null;
    ResultSet rset = null;

    Cart cart = null;
    try {
      final String query = "SELECT * FROM cart WHERE id = ?";
      pstmt = con.prepareStatement(query);
      pstmt.setLong(1, key.getId());
      rset = pstmt.executeQuery();
      rset.next();
      cart = Cart.builder()
              .memberId(rset.getLong("member_id"))
              .productId(rset.getLong("product_id"))
              .productQuantity(rset.getInt("product_quantity"))
              .build();
      cart.setKey(new SingleKey<>(rset.getLong("id")));
    } catch(Exception e) {
      log.info(e.getMessage());
      throw new Exception("런타임 에러");
    } finally {
      // close db resources
      DaoFrame.close(rset);
      DaoFrame.close(pstmt);
      cp.releaseConnection(con);
    }

    return Optional.of(cart);
  }


  @Override
  public List<Cart> getAll() {
    return null;
  }

  public List<Cart> getAllByMemberId(Long memberId) throws Exception {
    Connection con = cp.getConnection();
    PreparedStatement pstmt = null;
    ResultSet rset = null;

    List<Cart> carts = new ArrayList<>();
    try {
      final String query = "SELECT * FROM cart WHERE member_id = ?";
      pstmt = con.prepareStatement(query);
      pstmt.setLong(1, memberId);
      rset = pstmt.executeQuery();
      while(rset.next()) {
        Cart cart = Cart.builder()
                .memberId(rset.getLong("member_id"))
                .productId(rset.getLong("product_id"))
                .productQuantity(rset.getInt("product_quantity"))
                .build();
        cart.setKey(new SingleKey<>(rset.getLong("id")));
        carts.add(cart);

      }
    } catch(Exception e) {
      log.info(e.getMessage());
      throw new Exception("런타임 에러");
    } finally {
      // close db resources
      DaoFrame.close(pstmt);
      cp.releaseConnection(con);
    }

    return carts;
  }

  @Override
  public void insert(Cart cart) throws Exception {
    Connection con = cp.getConnection();
    PreparedStatement pstmt = null;

    int result = 0;
    try {
      final String query = "INSERT INTO cart (product_id, member_id, product_quantity) VALUES (?, ?, ?)";
      pstmt = con.prepareStatement(query);
      pstmt.setLong(1, cart.getProductId().longValue());
      pstmt.setLong(2, cart.getMemberId().longValue());
      pstmt.setInt(3, cart.getProductQuantity());
      result = pstmt.executeUpdate();
    } catch(Exception e) {
      log.info(e.getMessage());
      throw new Exception("런타임 에러");
    } finally {
      // close db resources
      DaoFrame.close(pstmt);
      cp.releaseConnection(con);
    }
  }

  @Override
  public void delete(SingleKey<Long> key) throws Exception {
    Connection con = cp.getConnection();
    PreparedStatement pstmt = null;

    int result = 0;
    try {
      final String query = "DELETE FROM cart WHERE id = ?";
      pstmt = con.prepareStatement(query);
      pstmt.setLong(1, key.getId().longValue());
      result = pstmt.executeUpdate();
    } catch(Exception e) {
      log.info(e.getMessage());
      throw new Exception("런타임 에러");
    } finally {
      // close db resources
      DaoFrame.close(pstmt);
      cp.releaseConnection(con);
    }
  }

  public void deleteAllByMemberKey(SingleKey<Long> memberKey) throws Exception {
    Connection con = cp.getConnection();
    PreparedStatement pstmt = null;

    int result = 0;
    try {
      final String query = "DELETE FROM cart WHERE member_id = ?";
      pstmt = con.prepareStatement(query);
      pstmt.setLong(1, memberKey.getId());
      result = pstmt.executeUpdate();
    } catch(Exception e) {
      log.info(e.getMessage());
      throw new Exception("런타임 에러");
    } finally {
      // close db resources
      DaoFrame.close(pstmt);
      cp.releaseConnection(con);
    }
  }

  @Override
  public void update(Cart object) {

  }

  public void updateProductQuantityById(SingleKey<Long> key, int productQuantity) throws Exception {
    Connection con = cp.getConnection();
    PreparedStatement pstmt = null;

    int result = 0;
    try {
      final String query = "UPDATE cart SET product_quantity = ? WHERE id = ?";
      pstmt = con.prepareStatement(query);
      pstmt.setLong(1, productQuantity);
      pstmt.setLong(2, key.getId());
      result = pstmt.executeUpdate();
    } catch(Exception e) {
      log.info(e.getMessage());
      throw new Exception("런타임 에러");
    } finally {
      // close db resources
      DaoFrame.close(pstmt);
      cp.releaseConnection(con);
    }
  }
}
