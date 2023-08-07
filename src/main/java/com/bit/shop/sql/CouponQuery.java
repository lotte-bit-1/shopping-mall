package com.bit.shop.sql;

public interface CouponQuery {
    public static String insert = "INSERT INTO coupon (member_id, name, discount_policy, discount_value, is_used) VALUES (?,?,?,?,?)";
    String selectAll = "SELECT * FROM coupon";
}
