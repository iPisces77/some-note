package org.example.confg;

/**
 * @author fuhaixin 存放mapper.xml中的配置信息
 **/
public class MappedStatement {

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getResultType() {
    return resultType;
  }

  public void setResultType(String resultType) {
    this.resultType = resultType;
  }

  public String getParamType() {
    return paramType;
  }

  public void setParamType(String paramType) {
    this.paramType = paramType;
  }

  public String getSql() {
    return sql;
  }

  public void setSql(String sql) {
    this.sql = sql;
  }

  //id标识
  private String id;

  //返回值类型
  private String resultType;
  //参数类型
  private String paramType;
  //sql语句
  private String sql;

  public MappedStatement() {
  }

  public MappedStatement(String id, String resultType, String paramType, String sql) {
    this.id = id;
    this.resultType = resultType;
    this.paramType = paramType;
    this.sql = sql;
  }
}
