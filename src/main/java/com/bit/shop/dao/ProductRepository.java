package com.bit.shop.dao;

import com.bit.shop.domain.Member;
import com.bit.shop.domain.Product;
import com.bit.shop.domain.keys.SingleKey;
import com.bit.shop.dto.ProductResponseDto;
import com.bit.shop.util.ConnectionPool;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

public class ProductRepository implements DaoFrame<SingleKey<Long>, Product> {

    Logger log = Logger.getLogger("ProductRepository");
    ConnectionPool cp;

    public ProductRepository() {
        try {
            cp = ConnectionPool.create();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Optional<Product> getById(SingleKey<Long> key) {

        return Optional.empty();
    }

    @Override
    public List<Product> getAll() {
        log.info("Selected ...");
        List<Product> list = new ArrayList<>();

        Connection con = cp.getConnection();
        PreparedStatement pstmt = null;
        ResultSet rSet = null;
        Member member = null;
        try {

            pstmt = con.prepareStatement(
                "SELECT id, category_id, name, price, quantity, reg_date, code FROM product"
            );
            rSet = pstmt.executeQuery();

            while (rSet.next()) {
                list.add(
                    Product.builder()
                        .categoryId(rSet.getLong("category_id"))
                        .name(rSet.getString("name"))
                        .price(rSet.getLong("price"))
                        .quantity(rSet.getInt("quantity"))
                        .regDate(LocalDateTime.parse(rSet.getString("reg_date")))
                        .code(rSet.getString("code"))
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
    public void insert(Product product) {
        log.info("Inserted....");
        int result = 0;
        Connection con = cp.getConnection();
        PreparedStatement pstmt = null;
        try {
            pstmt = con.prepareStatement(
                "INSERT INTO product (category_id, name, price, quantity, code) VALUES (?, ?, ?, ?, ?) "
            );
            pstmt.setLong(1, product.getCategoryId());
            pstmt.setString(2, product.getName());
            pstmt.setLong(3, product.getPrice());
            pstmt.setInt(4, product.getQuantity());
            pstmt.setString(5, product.getCode());

            result = pstmt.executeUpdate();
        } catch (Exception e) {
            log.info(e.getMessage());
        } finally {
            cp.releaseConnection(con);
            DaoFrame.close(pstmt);
        }
    }

    @Override
    public void delete(SingleKey<Long> key) {
        log.info("Deleted..");
        int result = 0;
        Connection con = cp.getConnection();
        PreparedStatement pstmt = null;
        try {
            pstmt = con.prepareStatement(
                "DELETE FROM product WHERE id = ?"
            );
            pstmt.setLong(1, key.getId());
            result = pstmt.executeUpdate();
        } catch (Exception e) {
            log.info(e.getMessage());
        } finally {
            cp.releaseConnection(con);
            DaoFrame.close(pstmt);
        }
    }

    @Override
    public void update(Product product) {
        log.info("Updated...");
        int result = 0;
        Connection con = cp.getConnection();
        PreparedStatement pstmt = null;
        try {
            pstmt = con.prepareStatement(
                "UPDATE product SET name =?, price =?, "
                    + " quantity =? WHERE id =?"
            );
            pstmt.setString(1, product.getName());
            pstmt.setLong(2, product.getPrice());
            pstmt.setInt(3, product.getQuantity());
            pstmt.setLong(4, product.getKey().getId());
            result = pstmt.executeUpdate();
        } catch (Exception e) {
            log.info(e.getMessage());
        } finally {
            cp.releaseConnection(con);
            DaoFrame.close(pstmt);
        }
    }

    public Optional<ProductResponseDto> getDtoById(Long id) {
        log.info("Selected ...");
        Connection con = cp.getConnection();
        PreparedStatement pstmt = null;
        ResultSet rSet = null;
        ProductResponseDto productResponseDto = null;
        try {

            pstmt = con.prepareStatement(
                "SELECT id, category_id, name, price, quantity, reg_date, code FROM product"
            );
            rSet = pstmt.executeQuery();

            while (rSet.next()) {

                productResponseDto = ProductResponseDto.builder()
                    .id(rSet.getLong("id"))
                    .categoryId(rSet.getLong("category_id"))
                    .name(rSet.getString("name"))
                    .price(rSet.getLong("price"))
                    .quantity(rSet.getInt("quantity"))
                    .regDate(LocalDateTime.parse(rSet.getString("reg_date")))
                    .code(rSet.getString("code"))
                    .build();
            }

        } catch (Exception e) {
            log.info(e.getMessage());
        } finally {
            cp.releaseConnection(con);
            DaoFrame.close(pstmt, rSet);
        }
        return Optional.ofNullable(productResponseDto);

    }

    public List<ProductResponseDto> getAllDto() {
        log.info("Selected ...");
        List<ProductResponseDto> list = new ArrayList<>();

        Connection con = cp.getConnection();
        PreparedStatement pstmt = null;
        ResultSet rSet = null;
        try {

            pstmt = con.prepareStatement(
                "SELECT id, category_id, name, price, quantity, reg_date, code FROM product"
            );
            rSet = pstmt.executeQuery();

            while (rSet.next()) {
                list.add(
                    ProductResponseDto.builder()
                        .id(rSet.getLong("id"))
                        .categoryId(rSet.getLong("category_id"))
                        .name(rSet.getString("name"))
                        .price(rSet.getLong("price"))
                        .quantity(rSet.getInt("quantity"))
                        .regDate(LocalDateTime.parse(rSet.getString("reg_date")))
                        .code(rSet.getString("code"))
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
}
