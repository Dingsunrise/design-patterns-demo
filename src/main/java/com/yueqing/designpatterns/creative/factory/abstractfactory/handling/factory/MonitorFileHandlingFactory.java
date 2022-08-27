package com.yueqing.designpatterns.creative.factory.abstractfactory.handling.factory;

import java.io.File;

import com.yueqing.designpatterns.creative.factory.abstractfactory.display.FileDisplay;
import com.yueqing.designpatterns.creative.factory.abstractfactory.display.InternetDisplay;
import com.yueqing.designpatterns.creative.factory.abstractfactory.read.FileRead;
import com.yueqing.designpatterns.creative.factory.abstractfactory.read.WebFileRead;
import com.yueqing.designpatterns.creative.factory.method.PlatformSimpleFileParseFactory;
import com.yueqing.designpatterns.creative.factory.method.methodfactory.FileParseFactory;
import com.yueqing.example.parse.FileParse;
import com.yueqing.example.parse.FileType;
import com.yueqing.example.parse.Platform;

/**
 * @author dingliming
 * @date 2022/7/16
 */
public class MonitorFileHandlingFactory implements FileHandlingFactory{
    @Override
    public File readFile(String path) {
        FileRead fileRead = new WebFileRead();
        return fileRead.readFile(path);
    }

    @Override
    public FileParse createFileParse(FileType fileType) {
        FileParseFactory fileParseFactory = PlatformSimpleFileParseFactory.getNonReusableFileParse(Platform.Linux);
        return fileParseFactory.createFileParse(fileType);
    }

    @Override
    public void display(String str) {
        FileDisplay fileDisplay = new InternetDisplay();
        fileDisplay.display(str);
    }
}
