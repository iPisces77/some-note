package org.example.dao;

import java.beans.IntrospectionException;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.List;
import org.example.pojo.User;

/**
 * @author fuhaixin
 * @date 2022-12-31
 **/
public interface UserDao {

  List<User> findAll()
      throws SQLException, IntrospectionException, NoSuchFieldException, InvocationTargetException, IllegalAccessException, NoSuchMethodException, InstantiationException;

  User findByCondition(User user)
      throws SQLException, IntrospectionException, NoSuchFieldException, InvocationTargetException, IllegalAccessException, NoSuchMethodException, InstantiationException;
}
