package com.yueqing.designpatterns.behavioral.chainofresponsibility;

import java.io.File;

import com.yueqing.example.parse.FileParse;

/**
 * @author dingliming
 * @date 2022/7/4
 */
public class PropertiesParse implements FileParse {
    private final FileParse fileParse;

    public PropertiesParse(FileParse fileParse) {
        this.fileParse = fileParse;
    }

    @Override
    public String parse(File file) {
        if(checkFileIsProperties(file)){
            //解析Properties文件 。。。
            return null;
        }
        //解析Properties文件 。。。
        return fileParse.parse(file);
    }

    private boolean checkFileIsProperties(File file){
        //...
        return true;
    }
}
