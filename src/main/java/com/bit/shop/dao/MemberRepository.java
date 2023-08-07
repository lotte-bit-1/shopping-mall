package com.bit.shop.dao;

import com.bit.shop.domain.Member;
import com.bit.shop.domain.keys.SingleKey;
import com.bit.shop.dto.LoginMember;
import com.bit.shop.dto.MemberResponseDto;
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
    public Optional<Member> getById(SingleKey<Long> key) throws Exception {

        log.info("Selected id: "+key.getId());
        Connection connection = cp.getConnection();
        PreparedStatement pStmt = null;
        ResultSet rSet = null;
        Member member = null;
        try {
            pStmt = connection.prepareStatement(
                "SELECT id, email, password, name FROM member WHERE id=?"
            );
            pStmt.setLong(1, key.getId());
            rSet = pStmt.executeQuery();

            if (rSet.next()) {

                member = Member.builder()
                    .email(rSet.getString("email"))
                    .password(rSet.getString("password"))
                    .name(rSet.getString("name"))
                    .build();
            }
        } catch (Exception e) {
            log.info(e.getMessage());
            throw new Exception("회원가입에러");
        } finally {
            cp.releaseConnection(connection);
            DaoFrame.close(pStmt, rSet);
        }
        return Optional.ofNullable(member);
    }

    @Override
    public List<Member> getAll() throws Exception {

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
    public void insert(Member member) throws Exception {
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
    public void delete(SingleKey<Long> key) throws Exception {
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
            throw new Exception("삭제에러");
        } finally {
            cp.releaseConnection(con);
            DaoFrame.close(pstmt);
        }
        //return result;
    }

    @Override
    public void update(Member member) throws Exception {
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
            throw new Exception("조회에러");
        } finally {
            cp.releaseConnection(con);
            DaoFrame.close(pstmt);
        }
        //return result;
    }

    public Optional<MemberResponseDto> getDtoById(Long id) throws Exception {
        log.info("Selected: " + id);
        Connection con = cp.getConnection();
        PreparedStatement pstmt = null;
        ResultSet rSet = null;
        MemberResponseDto memberResponseDto = null;

        try {
            pstmt = con.prepareStatement(
                "SELECT id, email, password, name FROM member WHERE id=?"
            );
            pstmt.setLong(1, id);
            rSet = pstmt.executeQuery();
            if(rSet.next()) {
                memberResponseDto = MemberResponseDto.builder()
                    .id(rSet.getLong("id"))
                    .email(rSet.getString("email"))
                    .name(rSet.getString("name"))
                    .build();
            }

        } catch (Exception e) {
            log.info(e.getMessage());
            throw new Exception("조회에러");
        } finally {
            cp.releaseConnection(con);
            DaoFrame.close(pstmt, rSet);
        }

        return Optional.ofNullable(memberResponseDto);
    }

    public Optional<LoginMember> getByEmailAndPassword(String email, String password) throws Exception {
        log.info("Selected: " + email);
        Connection con = cp.getConnection();
        PreparedStatement pstmt = null;
        ResultSet rSet = null;
        LoginMember loginMember = null;
        try {
            pstmt = con.prepareStatement(
                "SELECT id, email, name FROM member WHERE email = ?"
                    + "AND password = ?"
            );
            pstmt.setString(1, email);
            pstmt.setString(2, password);
            rSet = pstmt.executeQuery();
            if(rSet.next()) {
                loginMember = LoginMember.builder()
                    .id(rSet.getLong("id"))
                    .email(rSet.getString("email"))
                    .name(rSet.getString("name"))
                    .build();
            }

        } catch (Exception e) {
            log.info(e.getMessage());
            throw new Exception("조회에러");
        } finally {
            cp.releaseConnection(con);
            DaoFrame.close(pstmt, rSet);
        }
        return Optional.ofNullable(loginMember);
    }

    public void deleteByEmail(String email) throws Exception {
        log.info("Deleted: " + email);
        int result = 0;
        Connection con = cp.getConnection();
        PreparedStatement pstmt = null;
        try {
            pstmt = con.prepareStatement(
                "DELETE FROM member WHERE email = ?"
            );
            pstmt.setString(1, email);
            result = pstmt.executeUpdate();
        } catch (Exception e) {
            log.info(e.getMessage());
            throw new Exception("삭제에러");
        } finally {
            cp.releaseConnection(con);
            DaoFrame.close(pstmt);
        }
    }

    public void deleteAll() throws Exception {
        log.info("DeletedAll: ");
        int result = 0;
        Connection con = cp.getConnection();
        PreparedStatement pstmt = null;
        try {
            pstmt = con.prepareStatement(
                "DELETE FROM member"
            );
            result = pstmt.executeUpdate();
        } catch (Exception e) {
            log.info(e.getMessage());
            throw new Exception("삭제에러.");
        } finally {
            cp.releaseConnection(con);
            DaoFrame.close(pstmt);
        }
        //return result;
    }

}
