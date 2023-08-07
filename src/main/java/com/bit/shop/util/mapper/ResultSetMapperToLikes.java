package com.bit.shop.util.mapper;

import com.bit.shop.domain.Likes;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class ResultSetMapperToLikes implements CompKeyResultSetMapper<Likes> {

  @Override
  public List<Likes> convert(ResultSet rs) throws SQLException {
    List<Likes> likes = new ArrayList<>();
    if (rs.next()) {
      Long memberId = rs.getLong(1);//rs.getInt("role_id"); 이렇게 해도 된다.
      Long productId = rs.getLong(2);
      likes.add(new Likes(memberId, productId));
    }
    return likes;
  }
  }
