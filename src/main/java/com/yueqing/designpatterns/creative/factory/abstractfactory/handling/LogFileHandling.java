package com.yueqing.designpatterns.creative.factory.abstractfactory.handling;

import java.io.File;

import com.yueqing.designpatterns.creative.factory.abstractfactory.handling.factory.FileHandlingFactory;
import com.yueqing.example.parse.FileParse;
import com.yueqing.example.parse.FileType;

/**
 * @author dingliming
 * @date 2022/7/16
 */
public class LogFileHandling implements FileHandling{

    private final FileHandlingFactory fileHandlingFactory;

    public LogFileHandling(FileHandlingFactory fileHandlingFactory) {
        this.fileHandlingFactory = fileHandlingFactory;
    }

    @Override
    public void handlingFile(String path) {
        File file = fileHandlingFactory.readFile(path);
        FileParse fileParse = fileHandlingFactory.createFileParse(FileType.JSON);
        fileHandlingFactory.display(fileParse.parse(file));
    }
}
