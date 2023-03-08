package org.example.session;

import org.example.confg.Configuration;

/**
 * @author fuhaixin
 * @date 2022-12-23
 **/
public class DefaultSqlSessionFactory implements SqlSessionFactory {

  private Configuration configuration;

  public DefaultSqlSessionFactory(Configuration configuration) {
    this.configuration = configuration;
  }

  @Override
  public SqlSession openSession() {
    return new DefaultSqlSession(configuration);
  }
}
