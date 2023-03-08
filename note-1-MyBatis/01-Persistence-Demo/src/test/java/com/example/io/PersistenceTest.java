package com.example.io;

import java.beans.IntrospectionException;
import java.beans.PropertyVetoException;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import org.dom4j.DocumentException;
import org.example.dao.UserDao;
import org.example.io.Resources;
import org.example.pojo.User;
import org.example.session.SqlSessionFactory;
import org.example.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.Test;

/**
 * @author fuhaixin
 * @date 2022-12-23
 **/
public class PersistenceTest {

  @Test
  void resoucesTest() {
    var inputStream = Resources.getResourcesAsStream("sqlMapConfig.xml");
    SqlSessionFactory sqlSessionFactory = null;
    try {
      sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    } catch (PropertyVetoException | DocumentException e) {
      throw new RuntimeException(e);
    }
    var sqlSession = sqlSessionFactory.openSession();
    var user = new User();
    user.setId(1L);
    user.setUsername("lisi");
    try {
//      User o = sqlSession.selectOne("user.selectOne", user);
      var list = sqlSession.selectList("org.example.dao.UserDao.findAll");
      System.out.println(list);
    } catch (SQLException | IntrospectionException | NoSuchFieldException |
             InvocationTargetException | IllegalAccessException | NoSuchMethodException |
             InstantiationException e) {
      throw new RuntimeException(e);
    }

  }

  @Test
  void proxyTest()
      throws SQLException, IntrospectionException, NoSuchFieldException, InvocationTargetException, IllegalAccessException, NoSuchMethodException, InstantiationException {
    var inputStream = Resources.getResourcesAsStream("sqlMapConfig.xml");
    SqlSessionFactory sqlSessionFactory = null;
    try {
      sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    } catch (PropertyVetoException | DocumentException e) {
      throw new RuntimeException(e);
    }
    var sqlSession = sqlSessionFactory.openSession();
    UserDao mapper = sqlSession.getMapper(UserDao.class);
    var all = mapper.findAll();
    all.stream().forEach(System.out::println);

  }
}
