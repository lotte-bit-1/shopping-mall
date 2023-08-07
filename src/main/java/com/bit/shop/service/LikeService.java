package com.bit.shop.service;

import com.bit.shop.domain.Likes;
import com.bit.shop.domain.Member;
import com.bit.shop.domain.keys.CompositeKey;
import com.bit.shop.dto.LikeProductDto;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public interface LikeService {

  void doLike(Likes like) throws SQLException;
  void cancelLike(Likes like) throws SQLException;
  Optional<Likes> getOneLike(CompositeKey<Long> compositeKey) throws SQLException;
  List<Likes> getMyLikeList(Long memberId) throws SQLException;
}
