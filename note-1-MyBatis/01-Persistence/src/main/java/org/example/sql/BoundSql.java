package org.example.sql;

import java.util.List;
import org.example.utils.ParameterMapping;

/**
 * @author fuhaixin
 * @date 2022-12-26
 **/
public class BoundSql {

  //解析过后的sql
  private String sqlText;
  private List<ParameterMapping> parameterMappings;

  public BoundSql() {
  }

  public BoundSql(String sqlText, List<ParameterMapping> parameterMappings) {
    this.sqlText = sqlText;
    this.parameterMappings = parameterMappings;
  }

  public String getSqlText() {
    return sqlText;
  }

  public void setSqlText(String sqlText) {
    this.sqlText = sqlText;
  }

  public List<ParameterMapping> getParameterMappings() {
    return parameterMappings;
  }

  public void setParameterMappings(List<ParameterMapping> parameterMappings) {
    this.parameterMappings = parameterMappings;
  }
}
