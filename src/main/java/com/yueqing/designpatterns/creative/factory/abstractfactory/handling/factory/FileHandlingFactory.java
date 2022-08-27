package com.yueqing.designpatterns.creative.factory.abstractfactory.handling.factory;

import java.io.File;

import com.yueqing.example.parse.FileParse;
import com.yueqing.example.parse.FileType;

/**
 * @author dingliming
 * @date 2022/7/16
 */
public interface FileHandlingFactory {

    File readFile(String path);

    FileParse createFileParse(FileType fileType);

    void display(String str);
}
