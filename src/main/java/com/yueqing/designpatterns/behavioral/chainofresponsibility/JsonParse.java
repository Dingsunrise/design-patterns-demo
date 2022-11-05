package com.yueqing.designpatterns.behavioral.chainofresponsibility;

import java.io.File;

import com.yueqing.example.parse.FileParse;

/**
 * @author dingliming
 * @date 2022/7/4
 */
public class JsonParse implements FileParse {

    private final FileParse fileParse;

    public JsonParse(FileParse fileParse) {
        this.fileParse = fileParse;
    }

    @Override
    public String parse(File file) {
        if(checkFileIsJson(file)){
            //解析json文件 。。。
            return null;
        }
        //解析json文件 。。。
        return fileParse.parse(file);
    }

    private boolean checkFileIsJson(File file){
        //...
        return true;
    }
}
