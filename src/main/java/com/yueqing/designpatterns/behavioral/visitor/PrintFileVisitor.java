package com.yueqing.designpatterns.behavioral.visitor;

/**
 * @author dingliming
 * @date 2022/8/9
 */
public class PrintFileVisitor implements Visitor{
    @Override
    public void dealXmlFile(XmlParse xmlParse) {
        System.out.println("print xml");
    }

    @Override
    public void dealJsonFile(JsonParse jsonParse) {
        System.out.println("print json");
    }

    @Override
    public void dealPropertiesFile(PropertiesParse propertiesParse) {
        System.out.println("print properties");
    }
}
