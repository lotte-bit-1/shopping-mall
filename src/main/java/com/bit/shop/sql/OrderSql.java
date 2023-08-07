package com.bit.shop.sql;

public class OrderSql {
    public static final String SELECT_BY_ID = "SELECT * FROM orders WHERE id = ?";
    public static final String SELECT_ALL = "SELECT * FROM orders";
    public static final String SELECT_BY_MEMBER_ID = "SELECT * FROM orders WHERE member_id = ?";
    public static final String INSERT = "INSERT INTO orders(member_id, status) VALUES (?, ?)";
    public static final String DELETE_BY_ID = "DELETE FROM orders WHERE id = ?";
    public static final String DELETE_ALL = "DELETE FROM orders";
    public static final String UPDATE_BY_ID = "UPDATE orders SET member_id = ?, status = ? WHERE id = ?";
}
