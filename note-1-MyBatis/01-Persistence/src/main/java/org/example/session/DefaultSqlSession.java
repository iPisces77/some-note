package org.example.session;

import java.beans.IntrospectionException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Proxy;
import java.sql.SQLException;
import java.util.List;
import org.example.confg.Configuration;
import org.example.executor.SimpleExecutor;

/**
 * @author fuhaixin
 * @date 2022-12-23
 **/
public class DefaultSqlSession implements SqlSession {

  private Configuration configuration;

  public DefaultSqlSession(Configuration configuration) {
    this.configuration = configuration;
  }


  @Override
  public <E> E selectOne(String statementId, Object... params)
      throws SQLException, IntrospectionException, NoSuchFieldException, InvocationTargetException, IllegalAccessException, NoSuchMethodException, InstantiationException {
    var list = this.<E>selectList(statementId, params);
    if (list.size() == 1) {
      return list.get(0);
    } else {
      throw new RuntimeException("查询结果为空或者返回结果过多");
    }
  }

  @Override
  public <E> List<E> selectList(String statementId, Object... params)
      throws SQLException, IntrospectionException, NoSuchFieldException, InvocationTargetException, IllegalAccessException, NoSuchMethodException, InstantiationException {
    var mappedStatement = configuration.getMappedStatementMap().get(statementId);
//调用Executor执行查询

    var simpleExecutor = new SimpleExecutor();
    return simpleExecutor.query(configuration, mappedStatement, params);

  }

  @Override
  public void update() {

  }

  @Override
  public void delete() {

  }

  @Override
  public <T> T getMapper(Class<?> mapperClass) {

    return (T) Proxy.newProxyInstance(DefaultSqlSession.class.getClassLoader(),
        new Class[]{mapperClass},
        (proxy, method, args) -> {
          //准备参数1：statementId=namespace.id
          //准备参数2：params=args
          //调用selectList方法
          var methodName = method.getName();

          var className = method.getDeclaringClass().getName();
          var statementId = className + "." + methodName;
          var genericReturnType = method.getGenericReturnType();
          if (genericReturnType instanceof Class) {
            return selectOne(statementId, args);
          } else if (genericReturnType instanceof java.lang.reflect.ParameterizedType) {
            return selectList(statementId, args);
          }
          return this.selectList(statementId, args);
        });

  }
}
