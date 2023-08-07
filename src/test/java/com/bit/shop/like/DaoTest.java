package com.bit.shop.like;

import com.bit.shop.dao.LikesRepository;
import com.bit.shop.domain.Likes;
import com.bit.shop.util.mapper.ResultSetMapperToLikes;
import java.sql.SQLException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;



public class DaoTest {

  private static LikesRepository likesRepository;


  @BeforeEach
   void init() {
        likesRepository = new LikesRepository(new ResultSetMapperToLikes());
    }


  @Test
  public void insert() throws SQLException {
    Likes likes = new Likes(1L,1L);
    likesRepository.insert(likes);
  }

  @Test
  public void delete() throws SQLException {
    likesRepository.delete(new Likes(1L,1L).getCompositeKey());

  }
}
