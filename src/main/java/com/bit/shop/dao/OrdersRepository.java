package com.bit.shop.dao;

import com.bit.shop.domain.Orders;
import com.bit.shop.domain.keys.SingleKey;
import com.bit.shop.dto.OrdersDto;
import com.bit.shop.sql.OrderSql;
import com.bit.shop.util.ConnectionPool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

public class OrdersRepository implements DaoFrame<SingleKey<Long>, Orders> {

    ConnectionPool cp;

    Logger log = Logger.getLogger("OrderRepository");

    public OrdersRepository() {
        try {
            cp = ConnectionPool.create();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Optional<Orders> getById(SingleKey<Long> key) throws Exception {
        Connection con = cp.getConnection();
        PreparedStatement pstmt = null;
        ResultSet rSet = null;
        Orders orders = null;

        try {
            pstmt = con.prepareStatement(OrderSql.SELECT_BY_ID);
            pstmt.setLong(1, key.getId());

            rSet = pstmt.executeQuery();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            if (rSet.next()) {
                orders = Orders.builder()
                        .memberId(rSet.getLong("member_id"))
                        .regDate(LocalDateTime.parse(rSet.getString("reg_date"), formatter))
                        .status(rSet.getString("status"))
                        .build();
            }
        } catch (NullPointerException e) {
            log.info(e.getMessage());
            throw new Exception("주문 정보가 없음");
        } catch (Exception e) {
            log.info(e.getMessage());
            throw new Exception("주문 조회 에러");
        } finally {
            DaoFrame.close(pstmt, rSet);
            cp.releaseConnection(con);
        }

        return Optional.of(orders);
    }

    @Override
    public List<Orders> getAll() throws Exception {
        Connection con = cp.getConnection();
        PreparedStatement pstmt = null;
        ResultSet rSet = null;
        List<Orders> list = new ArrayList<>();

        try {
            pstmt = con.prepareStatement(OrderSql.SELECT_ALL);

            rSet = pstmt.executeQuery();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            while (rSet.next()) {
                list.add(
                        Orders.builder()
                        .memberId(rSet.getLong("member_id"))
                        .regDate(LocalDateTime.parse(rSet.getString("reg_date"), formatter))
                        .status(rSet.getString("status"))
                        .build()
                );
            }
        } catch (Exception e) {
            log.info(e.getMessage());
            throw new Exception("총 주문 조회 에러");
        } finally {
            DaoFrame.close(pstmt, rSet);
            cp.releaseConnection(con);
        }

        return list;
    }

    public List<Orders> getMembersOrder(Long memberId) throws Exception {
        Connection con = cp.getConnection();
        PreparedStatement pstmt = null;
        ResultSet rSet = null;
        List<Orders> list = new ArrayList<>();

        try {
            pstmt = con.prepareStatement(OrderSql.SELECT_BY_MEMBER_ID);
            pstmt.setLong(1, memberId);

            rSet = pstmt.executeQuery();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            while (rSet.next()) {
                list.add(
                        Orders.builder()
                                .memberId(rSet.getLong("member_id"))
                                .regDate(LocalDateTime.parse(rSet.getString("reg_date"), formatter))
                                .status(rSet.getString("status"))
                                .build()
                );
            }
        } catch (Exception e) {
            log.info(e.getMessage());
            throw new Exception("총 주문 조회 에러");
        } finally {
            DaoFrame.close(pstmt, rSet);
            cp.releaseConnection(con);
        }

        return list;
    }

    @Override
    public void insert(Orders orders) throws Exception {
        int result = 0;
        Connection con = cp.getConnection();
        PreparedStatement pstmt = null;

        try {
            pstmt = con.prepareStatement(OrderSql.INSERT);
            pstmt.setLong(1, orders.getMemberId());
            pstmt.setString(2, orders.getStatus());
            result = pstmt.executeUpdate();
        } catch (Exception e) {
            log.info(e.getMessage());
            throw new Exception("주문 추가 에러");
        } finally {
            DaoFrame.close(pstmt);
            cp.releaseConnection(con);
        }

//        return result;
    }

    public Long insertAndGet(Orders orders) throws Exception {
        int result = 0;
        Long id = -1L;
        Connection con = cp.getConnection();
        PreparedStatement pstmt = null;
        ResultSet rSet = null;


        try {
            String[] generalColumns = {"id"};
            pstmt = con.prepareStatement(OrderSql.INSERT, generalColumns);
            pstmt.setLong(1, orders.getMemberId());
            pstmt.setString(2, orders.getStatus());
            result = pstmt.executeUpdate();

            rSet = pstmt.getGeneratedKeys();
            if (rSet.next()) {
                id = Long.parseLong(rSet.getString(1));
            }
        } catch (Exception e) {
            log.info(e.getMessage());
            throw new Exception("주문 추가 에러");
        } finally {
            DaoFrame.close(pstmt);
            cp.releaseConnection(con);
        }

        return id;
    }

    @Override
    public void delete(SingleKey<Long> key) throws Exception {
        int result = 0;
        Connection con = cp.getConnection();
        PreparedStatement pstmt = null;
        try {
            pstmt = con.prepareStatement(OrderSql.DELETE_BY_ID);
            pstmt.setLong(1, key.getId());
            result = pstmt.executeUpdate();
        } catch (Exception e) {
            log.info(e.getMessage());
            throw new Exception("주문 삭제 에러");
        } finally {
            DaoFrame.close(pstmt);
            cp.releaseConnection(con);
        }

//        return result;
    }

    public void deleteAll() throws Exception {
        Connection con = cp.getConnection();
        PreparedStatement pstmt = null;
        try {
            pstmt = con.prepareStatement(OrderSql.DELETE_ALL);
            pstmt.executeUpdate();

        } catch (Exception e) {
            log.info(e.getMessage());
            throw new Exception("총 주문 삭제 에러");
        } finally {
            DaoFrame.close(pstmt);
            cp.releaseConnection(con);
        }
    }

    @Override
    public void update(Orders orders) throws Exception {
        int result = 0;
        Connection con = cp.getConnection();
        PreparedStatement pstmt = null;
        try {
            pstmt = con.prepareStatement(OrderSql.UPDATE_BY_ID);
            pstmt.setLong(1, orders.getMemberId());
            pstmt.setString(2, orders.getStatus());
            pstmt.setLong(3, orders.getKey().getId());
            result = pstmt.executeUpdate();
        } catch (Exception e) {
            log.info(e.getMessage());
            throw new Exception("주문 수정 에러");
        } finally {
            DaoFrame.close(pstmt);
            cp.releaseConnection(con);
        }

//        return result;
    }
}
