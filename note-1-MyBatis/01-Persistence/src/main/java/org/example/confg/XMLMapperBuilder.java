package org.example.confg;

import java.io.InputStream;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;


/**
 * @author fuhaixin
 * @date 2022-12-23
 **/
public class XMLMapperBuilder {

  private Configuration configuration;

  public XMLMapperBuilder(Configuration configuration) {
    this.configuration = configuration;
  }

  public void parse(InputStream in) throws DocumentException {
    var document = new SAXReader().read(in);
    var rootElement = document.getRootElement();
    var namespace = rootElement.attributeValue("namespace");

    var elements = rootElement.selectNodes("//select");
    for (Node node : elements) {
      var element = (Element) node;
      var id = element.attributeValue("id");
      var resultType = element.attributeValue("resultType");
      var parameterType = element.attributeValue("parameterType");
      var sql = element.getTextTrim();
      var mappedStatement = new MappedStatement(id, resultType, parameterType,
          sql);
      configuration.getMappedStatementMap().put(namespace + "." + id, mappedStatement);
    }

  }
}
