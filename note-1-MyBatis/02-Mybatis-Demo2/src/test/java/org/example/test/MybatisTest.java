package org.example.test;

import java.io.IOException;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.example.account.mapper.OrderMapper;
import org.example.account.mapper.UserMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * @author fuhaixin
 * @date 2023-01-01
 **/
public class MybatisTest {

  private SqlSession sqlSession;

  @BeforeEach
  public void init() throws IOException {
    var resource = Resources.getResourceAsStream("sqlMapConfig.xml");
    var sqlSessionFactory = new SqlSessionFactoryBuilder().build(resource);
    sqlSession = sqlSessionFactory.openSession();
  }

  @Test
  public void test() {
    var mapper = sqlSession.getMapper(OrderMapper.class);
    mapper.findOrderAndUser().stream().forEach(System.out::println);
    sqlSession.close();
  }

  @Test
  public void testUser() {
    var mapper = sqlSession.getMapper(UserMapper.class);
    mapper.findUserAndOrder().stream().forEach(System.out::println);
    sqlSession.close();
  }

  @Test
  public void testUserAndRole() {
    var mapper = sqlSession.getMapper(UserMapper.class);
    mapper.findAllUserAndRole().stream().forEach(System.out::println);
    sqlSession.close();
  }
}
