package org.example.test;

import java.io.IOException;
import java.util.List;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.example.account.mapper.UserMapper;
import org.example.pojo.User;
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
  public void testSelect() throws IOException {

    var list = sqlSession.selectList("user.findAll");
    list.stream().forEach(System.out::println);
    sqlSession.close();

  }

  @Test
  public void testInsert() {
    var user = new User(6L, "wangwu");
    sqlSession.insert("user.saveUser", user);
    sqlSession.commit();
    sqlSession.close();
  }

  @Test
  public void testUpdate() {
    var user = new User(6L, "tt");
    sqlSession.update("user.updateUser", user);
    sqlSession.commit();
    sqlSession.close();
  }

  @Test
  public void testDelete() {

    sqlSession.delete("user.deleteUser", 6);
    sqlSession.commit();
    sqlSession.close();
  }

  @Test
  public void proxyTest() {
    var mapper = sqlSession.getMapper(UserMapper.class);
    mapper.findAll().forEach(System.out::println);

    mapper.findByIds(List.of(1L, 2L)).forEach(System.out::println);
  }
}
