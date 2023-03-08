package org.example.session;

import java.beans.PropertyVetoException;
import java.io.InputStream;
import org.dom4j.DocumentException;
import org.example.confg.XMLConfigBuilder;

/**
 * @author fuhaixin
 * @date 2022-12-23
 **/
public class SqlSessionFactoryBuilder {


  public SqlSessionFactory build(InputStream in) throws PropertyVetoException, DocumentException {
    //使用dom4j解析配置文件，将解析出来的内容封装到Configuration中
    XMLConfigBuilder xmlConfigBuilder = new XMLConfigBuilder();
    var configuration = xmlConfigBuilder.parseConfig(in);

    return new DefaultSqlSessionFactory(configuration);
  }
}
