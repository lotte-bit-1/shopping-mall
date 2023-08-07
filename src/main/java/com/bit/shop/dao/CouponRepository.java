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
  ConnectionPool connection;
  Connection con;

  public CouponRepository() {
    try {
      connection = ConnectionPool.create();
      con = connection.getConnection();
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
      pstmt = con.prepareStatement(CouponQuery.selectAll);
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
    }
  }

  @Override
  public void insert(Coupon coupon) throws Exception {
    log.info(CouponQuery.insert);
    try (PreparedStatement pstmt = connection.getConnection().prepareStatement(CouponQuery.insert)) {
      pstmt.setString(1, String.valueOf(coupon.getMemberId()));
      pstmt.setString(2, coupon.getName());
      pstmt.setString(3, coupon.getDiscountPolicy());
      pstmt.setString(4, String.valueOf(coupon.getDiscountValue()));
      pstmt.executeUpdate();
    } catch (Exception e) {
      log.info("쿠폰 생성 에러 ");
      throw new Exception("insert coupon error");
    }
  }

  @Override
  public void delete(SingleKey<Long> key) {

  }

  @Override
  public void update(Coupon object) {

  }
}
