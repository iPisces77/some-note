package org.example.executor;

import java.beans.IntrospectionException;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.List;
import org.example.confg.Configuration;
import org.example.confg.MappedStatement;

/**
 * @author fuhaixin
 * @date 2022-12-26
 **/
public interface Executor {

  <E> List<E> query(Configuration configuration, MappedStatement mappedStatement, Object... params)
      throws SQLException, NoSuchFieldException, IllegalAccessException, NoSuchMethodException, InvocationTargetException, InstantiationException, IntrospectionException;
}
