package com.bit.shop.dao;

import com.bit.shop.domain.Member;
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


public class MemberRepository implements DaoFrame<SingleKey<Long>, Member> {

    Logger log = Logger.getLogger("MemberDao");

    ConnectionPool cp;

    public MemberRepository() {
        try {
            cp = ConnectionPool.create();
        } catch (SQLException e) {
            log.warning("Connection 생성 중 에러 발생");
            e.printStackTrace();
        }
    }

    @Override
    public Optional<Member> getById(SingleKey<Long> key) {

        log.info("Selected : " + key.getId());

        Connection connection = cp.getConnection();
        PreparedStatement pStmt = null;
        Member member = null;
        try {
            pStmt = connection.prepareStatement(
                "SELECT id, email, password, name FROM cust WHERE id=?"
            );
            pStmt.setLong(1, key.getId());
            ResultSet rSet = pStmt.executeQuery();

            if (rSet.next()) {

                member = Member.builder()
                    .email(rSet.getString("email"))
                    .password(rSet.getString("password"))
                    .name(rSet.getString("name"))
                    .build();
            }
        } catch (Exception e) {
            log.info(e.getMessage());
        } finally {
            cp.releaseConnection(connection);
            DaoFrame.close();
        }
        return Optional.ofNullable(member);
    }

    @Override
    public List<Member> getAll() {

        log.info("Selected ...");

        List<Member> list = new ArrayList<>();

        Connection con = cp.getConnection();
        PreparedStatement pstmt = null;
        ResultSet rSet = null;
        Member member = null;
        try {

            pstmt = con.prepareStatement(
                "SELECT id, email, password, name FROM member"
            );
            rSet = pstmt.executeQuery();

            while (rSet.next()) {
                list.add(
                    Member.builder()
                        .email(rSet.getString("email"))
                        .password(rSet.getString("password"))
                        .name(rSet.getString("name"))
                        .build());
            }

        } catch (Exception e) {
            log.info(e.getMessage());
        } finally {
            cp.releaseConnection(con);
            DaoFrame.close(pstmt, rSet);
        }

        return list;
    }

    @Override
    public void insert(Member member) {
        log.info("Inserted: " + member.getEmail());
        int result = 0;
        Connection con = cp.getConnection();
        PreparedStatement pstmt = null;
        try {
            pstmt = con.prepareStatement(
                "INSERT INTO member (email, password, name) VALUES (?, ?, ?) "
            );
            pstmt.setString(1, member.getEmail());
            pstmt.setString(2, member.getPassword());
            pstmt.setString(3, member.getName());
            result = pstmt.executeUpdate();
        } catch (Exception e) {
            log.info(e.getMessage());
        } finally {
            cp.releaseConnection(con);
            DaoFrame.close(pstmt);
        }
        //return result;
    }

    @Override
    public void delete(SingleKey<Long> key) {
        log.info("Deleted: " + key.getId());
        int result = 0;
        Connection con = cp.getConnection();
        PreparedStatement pstmt = null;
        try {
            pstmt = con.prepareStatement(
                "DELETE FROM member WHERE id = ?"
            );
            pstmt.setLong(1, key.getId());
            result = pstmt.executeUpdate();
        } catch (Exception e) {
            log.info(e.getMessage());
        } finally {
            cp.releaseConnection(con);
            DaoFrame.close(pstmt);
        }
        //return result;
    }

    @Override
    public void update(Member member) {
        log.info("Updated: " + member.getKey().getId());
        int result = 0;
        Connection con = cp.getConnection();
        PreparedStatement pstmt = null;
        try {
            pstmt = con.prepareStatement(
                "UPDATE member SET password =?, name =? WHERE id =?"
            );
            pstmt.setString(1, member.getPassword());
            pstmt.setString(2, member.getName());
            pstmt.setLong(3, member.getKey().getId());
            result = pstmt.executeUpdate();
        } catch (Exception e) {
            log.info(e.getMessage());
        } finally {
            cp.releaseConnection(con);
            DaoFrame.close(pstmt);
        }
        //return result;
    }

}
