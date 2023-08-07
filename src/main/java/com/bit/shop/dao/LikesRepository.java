package com.bit.shop.dao;

import com.bit.shop.domain.Likes;
import com.bit.shop.domain.keys.CompositeKey;
import com.bit.shop.sql.LikesSql;
import com.bit.shop.util.ConnectionPool;
import com.bit.shop.util.mapper.CompKeyResultSetMapper;
import com.bit.shop.util.mapper.CompKeyToPrepareStatementString;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
import lombok.NoArgsConstructor;


@NoArgsConstructor
public class LikesRepository implements DaoFrame<CompositeKey<Long>, Likes> {

  private CompKeyResultSetMapper<Likes> mapper;

  public LikesRepository(CompKeyResultSetMapper<Likes> mapper) {
    this.mapper = mapper;
  }

  @Override
  public Optional<Likes> getById(CompositeKey<Long> key) throws SQLException {
    Connection connection = ConnectionPool.create().getConnection();
    PreparedStatement ps = connection.prepareStatement(LikesSql.READ_BY_ID);
    ResultSet rs = ps.executeQuery();
    List<Likes> likesList = mapper.convert(rs);
    return Optional.ofNullable(likesList.get(0));
  }

  public List<Likes> getAllByMember(Long memberId) throws SQLException {
    Connection connection = ConnectionPool.create().getConnection();
    PreparedStatement ps = connection.prepareStatement(LikesSql.READ_ALL_MEMBER);
    ResultSet rs = ps.executeQuery();
    return mapper.convert(rs);
  }

  @Override
  public List<Likes> getAll() throws SQLException {
    Connection connection = ConnectionPool.create().getConnection();
    PreparedStatement ps = connection.prepareStatement(LikesSql.READ_ALL);
    ResultSet rs = ps.executeQuery();
    return mapper.convert(rs);
  }

  @Override
  public void insert(Likes likes) throws SQLException {
    PreparedStatement ps = ConnectionPool.create().getConnection().prepareStatement(LikesSql.ADD);
    ps = CompKeyToPrepareStatementString.set(likes.getCompositeKey(), ps);
    int flag = ps.executeUpdate();
  }

  @Override
  public void delete(CompositeKey<Long> key) throws SQLException {
    PreparedStatement ps = ConnectionPool.create().getConnection().prepareStatement(LikesSql.DELETE);
    ps = CompKeyToPrepareStatementString.set(key, ps);
    int flag = ps.executeUpdate();
  }

  @Override
  public void update(Likes object) {
  }
}
