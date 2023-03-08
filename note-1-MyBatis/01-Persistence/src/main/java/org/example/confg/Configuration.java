package org.example.confg;

import java.util.HashMap;
import java.util.Map;
import javax.sql.DataSource;

/**
 * @author fuhaixin 存放sqlMapConfig.xml中的配置信息
 */

public class Configuration {

  private DataSource dataSource;
  private Map<String, MappedStatement> mappedStatementMap = new HashMap<>();

  public Configuration() {
  }

  public Configuration(DataSource dataSource, Map<String, MappedStatement> mappedStatementMap) {
    this.dataSource = dataSource;
    this.mappedStatementMap = mappedStatementMap;
  }

  public DataSource getDataSource() {
    return dataSource;
  }

  public void setDataSource(DataSource dataSource) {
    this.dataSource = dataSource;
  }

  public Map<String, MappedStatement> getMappedStatementMap() {
    return mappedStatementMap;
  }

  public void setMappedStatementMap(
      Map<String, MappedStatement> mappedStatementMap) {
    this.mappedStatementMap = mappedStatementMap;
  }
}
