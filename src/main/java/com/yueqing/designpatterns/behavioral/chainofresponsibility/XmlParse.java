package com.yueqing.designpatterns.behavioral.chainofresponsibility;

import java.io.File;

import com.yueqing.example.parse.FileParse;

/**
 * @author dingliming
 * @date 2022/7/4
 */
public class XmlParse implements FileParse {
    private final FileParse fileParse;

    public XmlParse(FileParse fileParse) {
        this.fileParse = fileParse;
    }

    @Override
    public String parse(File file) {
        if(checkFileIsXml(file)){
            //解析Xml文件 。。。
            return null;
        }
        //解析Xml文件 。。。
        return fileParse.parse(file);
    }

    private boolean checkFileIsXml(File file){
        //...
        return true;
    }
}
