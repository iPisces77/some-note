package org.example.confg;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import java.beans.PropertyVetoException;
import java.io.InputStream;
import java.util.Properties;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;
import org.example.io.Resources;

/**
 * @author fuhaixin
 * @date 2022-12-23
 **/
public class XMLConfigBuilder {

  private Configuration configuration;

  public XMLConfigBuilder() {
    this.configuration = new Configuration();
  }

  /**
   * 该方法将配置文件进行解析,封装到Configuration中
   *
   * @param in
   * @return
   */
  public Configuration parseConfig(InputStream in) throws DocumentException, PropertyVetoException {
    var document = new SAXReader().read(in);
    //<configuration>
    var rootElement = document.getRootElement();
    var elements = rootElement.selectNodes("//property");
    var properties = new Properties();
    for (var element : elements) {
      var propertyElement = (Element) element;
      var name = propertyElement.attributeValue("name");
      var value = propertyElement.attributeValue("value");
      properties.setProperty(name, value);
    }

    var mappers = rootElement.selectNodes("//mapper");
    for (Node mapper : mappers) {
      var mapperElement = (Element) mapper;
      var resource = mapperElement.attributeValue("resource");
      InputStream resourceAsStream = Resources.getResourcesAsStream(resource);

      var xmlMapperBuilder = new XMLMapperBuilder(configuration);
      xmlMapperBuilder.parse(resourceAsStream);
    }
    var comboPooledDataSource = new ComboPooledDataSource();
    comboPooledDataSource.setDriverClass(properties.getProperty("driverClass"));
    comboPooledDataSource.setJdbcUrl(properties.getProperty("url"));
    comboPooledDataSource.setUser(properties.getProperty("username"));
    comboPooledDataSource.setPassword(properties.getProperty("password"));

    configuration.setDataSource(comboPooledDataSource);
    return configuration;
  }
}
