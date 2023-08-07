package com.bit.shop.controller;

import com.bit.shop.domain.Likes;
import com.bit.shop.domain.keys.CompositeKey;
import com.bit.shop.dto.LikeProductDto;
import com.bit.shop.service.LikeService;
import java.sql.SQLException;
import java.util.List;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class LikeController {

  private final LikeService likeService;

  public void doLike(Likes like) throws SQLException {
    likeService.doLike(like);
  }

  public void cancelLike(Likes like) throws SQLException {
    likeService.cancelLike(like);
  }

  public LikeProductDto getOneMyLike(CompositeKey<Long> cp) throws SQLException {
    return null;

    // likeService.getOneLike(cp).orElseThrow(IllegalArgumentException::new).getProductId();

  }
  public List<LikeProductDto> getAllMyLikes(Long memberId) throws SQLException {

    return null;
    //product Id list likeService.getMyLikeList(memberId).stream().map(p -> p.getProductId()).collect(Collectors.toList());
  }


}
