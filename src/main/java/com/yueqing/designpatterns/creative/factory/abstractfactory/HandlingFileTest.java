package com.yueqing.designpatterns.creative.factory.abstractfactory;

import com.yueqing.designpatterns.creative.factory.abstractfactory.handling.FileHandling;
import com.yueqing.designpatterns.creative.factory.abstractfactory.handling.LogFileHandling;
import com.yueqing.designpatterns.creative.factory.abstractfactory.handling.factory.LogFileHandlingFactory;

/**
 * @author dingliming
 * @date 2022/7/16
 */
public class HandlingFileTest {

    public void handlingFile(String path){
        FileHandling fileHandling = new LogFileHandling(new LogFileHandlingFactory());
        fileHandling.handlingFile(path);
    }
}
