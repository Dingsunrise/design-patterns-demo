package com.yueqing.designpatterns.behavioral.visitor;

/**
 * @author dingliming
 * @date 2022/8/9
 */
public interface Visitor {

    void dealXmlFile(XmlParse xmlParse);

    void dealJsonFile(JsonParse jsonParse);

    void dealPropertiesFile(PropertiesParse propertiesParse);

}
