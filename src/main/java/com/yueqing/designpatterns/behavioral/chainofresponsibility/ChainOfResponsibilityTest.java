package com.yueqing.designpatterns.behavioral.chainofresponsibility;

import java.io.File;

/**
 * @author dingliming
 * @date 2022/7/30
 */
public class ChainOfResponsibilityTest {

    public static void main(String[] args) {
        File file = new File("");
        JsonParse jsonParse = new JsonParse(new PropertiesParse(new XmlParse(new FinalParse())));
        jsonParse.parse(file);
    }

}
