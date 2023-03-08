package org.example.dao;

import java.beans.IntrospectionException;
import java.beans.PropertyVetoException;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.List;
import org.dom4j.DocumentException;
import org.example.io.Resources;
import org.example.pojo.User;
import org.example.session.SqlSessionFactory;
import org.example.session.SqlSessionFactoryBuilder;

/**
 * @author fuhaixin
 * @date 2022-12-31
 **/
public class UserDaoImpl implements UserDao {

  @Override
  public List<User> findAll()
      throws SQLException, IntrospectionException, NoSuchFieldException, InvocationTargetException, IllegalAccessException, NoSuchMethodException, InstantiationException {
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
    return sqlSession.selectList("user.selectList");

  }

  @Override
  public User findByCondition(User user)
      throws SQLException, IntrospectionException, NoSuchFieldException, InvocationTargetException, IllegalAccessException, NoSuchMethodException, InstantiationException {
    var inputStream = Resources.getResourcesAsStream("sqlMapConfig.xml");
    SqlSessionFactory sqlSessionFactory = null;
    try {
      sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    } catch (PropertyVetoException | DocumentException e) {
      throw new RuntimeException(e);
    }
    var sqlSession = sqlSessionFactory.openSession();
    var user1 = new User();
    user1.setId(1L);
    user1.setUsername("lisi");
    return sqlSession.selectOne("user.selectOne", user);

  }
}
