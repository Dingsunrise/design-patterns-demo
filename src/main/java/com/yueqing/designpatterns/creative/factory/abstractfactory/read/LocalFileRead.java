package com.yueqing.designpatterns.creative.factory.abstractfactory.read;

import java.io.File;

/**
 * @author dingliming
 * @date 2022/7/16
 */
public class LocalFileRead implements FileRead {
    @Override
    public File readFile(String path) {
        //读取本地文件。。。
        return null;
    }
}
