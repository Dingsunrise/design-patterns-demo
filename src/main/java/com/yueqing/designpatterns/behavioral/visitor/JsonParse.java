package com.yueqing.designpatterns.behavioral.visitor;

import java.io.File;


/**
 * @author dingliming
 * @date 2022/7/4
 */
public class JsonParse implements FileParse {


    @Override
    public String parse(File file) {

        //解析json文件 。。。
        return "";
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.dealJsonFile(this);
    }

}
