package org.example.executor;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import org.example.confg.Configuration;
import org.example.confg.MappedStatement;
import org.example.sql.BoundSql;
import org.example.utils.GenericTokenParser;
import org.example.utils.ParameterMappingTokenHandler;

/**
 * @author fuhaixin
 * @date 2022-12-26
 **/
public class SimpleExecutor implements Executor {

  @Override
  public <E> List<E> query(
      Configuration configuration, MappedStatement mappedStatement, Object... params)
      throws SQLException, NoSuchFieldException, IllegalAccessException, NoSuchMethodException, InvocationTargetException, InstantiationException, IntrospectionException {
    var connection = configuration.getDataSource().getConnection();
    var boundSql = getBoundSql(mappedStatement.getSql());

    //获取预处理对象
    var preparedStatement = connection.prepareStatement(boundSql.getSqlText());
    //设置参数
    //获取参数的全路径
    var paramType = mappedStatement.getParamType();
    Class<?> parameterType = getClassType(paramType);

    for (int i = 0; i < boundSql.getParameterMappings().size(); i++) {
      //获取参数
      var parameterMapping = boundSql.getParameterMappings().get(i);
      var content = parameterMapping.getContent();

      var declaredField = parameterType.getDeclaredField(content);
      declaredField.setAccessible(true);
      var o = declaredField.get(params[0]);
      preparedStatement.setObject(i + 1, o);

    }
    //执行sql
    var resultSet = preparedStatement.executeQuery();
    //封装返回结果集
    var resultType = mappedStatement.getResultType();
    Class<?> resultTypeClass = getClassType(resultType);
    var results = new ArrayList<Object>();
    while (resultSet.next()) {
      Object o = resultTypeClass.getConstructor().newInstance();
      var metaData = resultSet.getMetaData();
      for (int i = 1; i <= metaData.getColumnCount(); i++) {
        var columnName = metaData.getColumnName(i);
        var value = resultSet.getObject(columnName);
        System.out.println(value.getClass().getSimpleName());
        var propertyDescriptor = new PropertyDescriptor(columnName, resultTypeClass);
        var writeMethod = propertyDescriptor.getWriteMethod();
        writeMethod.invoke(o, value);
      }
      results.add(o);
    }
    return (List<E>) results;
  }

  private Class<?> getClassType(String paramType) {
    if (Objects.nonNull(paramType)) {
      try {
        return Class.forName(paramType);
      } catch (ClassNotFoundException e) {
        e.printStackTrace();
      }
    }

    return null;
  }

  private BoundSql getBoundSql(String sql) {
    //标记处理类
    var tokenHandler = new ParameterMappingTokenHandler();
    var genericTokenParser = new GenericTokenParser("#{", "}", tokenHandler);

    var parseSql = genericTokenParser.parse(sql);
    var parameterMappings = tokenHandler.getParameterMappings();

    return new BoundSql(parseSql, parameterMappings);

  }
}
