package com.yueqing.designpatterns.behavioral.visitor;

import java.io.File;


/**
 * @author dingliming
 * @date 2022/7/4
 */
public class PropertiesParse implements FileParse {


    @Override
    public String parse(File file) {

        //解析Properties文件 。。。
        return "";
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.dealPropertiesFile(this);
    }

}
