package com.bit.shop.sql;

import javax.print.DocFlavor.STRING;

public class LikesSql {
  public static final String ADD= "INSERT INTO likes(member_id,product_id) VALUES(?,?)";
  public static final String DELETE ="DELETE FROM likes WHERE member_id = ? and product_id = ?";
  public static final String READ_BY_ID= "SELECT * FROM likes WHERE member_id = ? and product_id = ?";
  public static final String READ_ALL="SELECT * FROM likes";
  public static final String READ_ALL_MEMBER="SELECT * FROM likes WHERE member_id = ?";

}
