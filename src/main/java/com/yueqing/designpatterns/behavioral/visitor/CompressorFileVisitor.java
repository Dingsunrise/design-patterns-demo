package com.yueqing.designpatterns.behavioral.visitor;

/**
 * @author dingliming
 * @date 2022/8/9
 */
public class CompressorFileVisitor implements Visitor{
    @Override
    public void dealXmlFile(XmlParse xmlParse) {
        System.out.println("compressor xml file");
    }

    @Override
    public void dealJsonFile(JsonParse jsonParse) {
        System.out.println("compressor json file");
    }

    @Override
    public void dealPropertiesFile(PropertiesParse propertiesParse) {
        System.out.println("compressor properties file");
    }
}
