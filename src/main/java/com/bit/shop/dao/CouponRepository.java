package com.bit.shop.dao;

import com.bit.shop.domain.Coupon;
import com.bit.shop.domain.keys.SingleKey;
import com.bit.shop.sql.CouponQuery;
import com.bit.shop.util.ConnectionPool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

public class CouponRepository implements DaoFrame<SingleKey<Long>, Coupon> {
  ConnectionPool connectionPool;
  Connection connection;

  public CouponRepository() {
    try {
      connectionPool = ConnectionPool.create();
      connection = connectionPool.getConnection();
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }

  Logger log = Logger.getLogger("CouponRepository");

  @Override
  public Optional<Coupon> getById(SingleKey<Long> key) {
    return Optional.empty();
  }

  @Override
  public List<Coupon> getAll() throws Exception {
    PreparedStatement pstmt = null;
    List<Coupon> list = new ArrayList<>();
    ResultSet resultSet = null;
    try {
      pstmt = connection.prepareStatement(CouponQuery.SELECTALL);
      resultSet = pstmt.executeQuery();
      while (resultSet.next()) {
        Coupon coupon = Coupon.builder()
                .memberId(resultSet.getLong("member_id"))
                .name(resultSet.getString("name"))
                .discountValue(resultSet.getInt("discount_value"))
                .discountPolicy(resultSet.getString("discount_policy"))
                .isUsed(resultSet.getBoolean("is_used"))
                .build();
        list.add(coupon);
      }
      return list;
    } catch (Exception e) {
      throw new Exception("select error");
    } finally {
      connection.close();
    }
  }

  @Override
  public void insert(Coupon coupon) throws Exception {
    try (PreparedStatement pstmt = connection.prepareStatement(CouponQuery.INSERT)) {
      pstmt.setLong(1, coupon.getMemberId());
      pstmt.setString(2, coupon.getName());
      pstmt.setString(3, coupon.getDiscountPolicy());
      pstmt.setLong(4, coupon.getDiscountValue());
      pstmt.setBoolean(5, coupon.isUsed());
      pstmt.executeUpdate();
    } catch (Exception e) {
      log.info("쿠폰 생성 에러 ");
      throw new Exception("insert coupon error");
    } finally {
      connection.close();
    }
  }

  /**
   * 쿠폰을 사용하면 쿠폰이 삭제 된다
   *
   * @param key coupon id
   */
  @Override
  public void delete(SingleKey<Long> key) throws Exception {
    try (PreparedStatement pstmt = connection.prepareStatement(CouponQuery.DELETE)) {
      pstmt.setLong(1, key.getId());
      pstmt.executeUpdate();
    } catch (Exception e) {
      throw new Exception("delete coupon error");
    } finally {
      connection.close();
    }
  }

  @Override
  public void update(Coupon object) throws Exception {
    try (PreparedStatement pstmt = connection.prepareStatement(CouponQuery.UPDATE)) {
      pstmt.setString(1, object.getName());
      pstmt.setLong(2, object.getMemberId());
      pstmt.executeUpdate();
    } catch (Exception e) {
      throw new Exception("delete coupon error");
    } finally {
      connection.close();
    }

  }
}
