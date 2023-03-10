package org.example.plugin;

import java.sql.Connection;
import java.util.Properties;
import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Plugin;
import org.apache.ibatis.plugin.Signature;

/**
 * @author fuhaixin
 * @date 2023-01-01
 **/
@Intercepts(@Signature(type = StatementHandler.class, method = "prepare", args = {Connection.class,
    Integer.class}))
public class MyPlugin implements Interceptor {

  @Override
  public Object plugin(Object target) {
    return Plugin.wrap(target, this);
  }

  @Override
  public void setProperties(Properties properties) {
    System.out.println("插件配置的初始化参数：" + properties);
  }

  @Override
  public Object intercept(Invocation invocation) throws Throwable {
    System.out.println("对方法进行了增强");
    return invocation.proceed();
  }

}
