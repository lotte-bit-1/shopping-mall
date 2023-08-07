package com.bit.shop.service.impl;

import com.bit.shop.dao.LikesRepository;
import com.bit.shop.domain.Likes;
import com.bit.shop.domain.keys.CompositeKey;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import com.bit.shop.service.LikeService;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class LikeServiceImpl implements LikeService {

  private final LikesRepository likesRepository;


  @Override
  public void doLike(Likes like) throws SQLException {
    likesRepository.insert(like);
  }

  @Override
  public void cancelLike(Likes like) throws SQLException {
    likesRepository.delete(like.getKey());
  }

  @Override
  public Optional<Likes> getOneLike(CompositeKey<Long> compositeKey) throws SQLException {
    return likesRepository.getById(compositeKey);
  }

  @Override
  public List<Likes> getMyLikeList(Long memberId) throws SQLException {
    return likesRepository.getAllByMember(memberId);
  }
}
