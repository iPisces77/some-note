package org.example.session;

import java.beans.IntrospectionException;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.List;

/**
 * @author fuhaixin
 * @date 2022-12-23
 **/
public interface SqlSession {

  <E> E selectOne(String statementId, Object... params)
      throws SQLException, IntrospectionException, NoSuchFieldException, InvocationTargetException, IllegalAccessException, NoSuchMethodException, InstantiationException;

  <E> List<E> selectList(String statementId, Object... params)
      throws SQLException, IntrospectionException, NoSuchFieldException, InvocationTargetException, IllegalAccessException, NoSuchMethodException, InstantiationException;

  void update();

  void delete();

  <T> T getMapper(Class<?> mapperClass);
}
