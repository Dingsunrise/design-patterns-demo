package com.yueqing.designpatterns.creative.factory.method.methodfactory;

import com.yueqing.designpatterns.creative.factory.simple.LinuxSimpleFileParseFactory;
import com.yueqing.example.parse.FileParse;
import com.yueqing.example.parse.FileType;

/**
 * @author dingliming
 * @date 2022/7/16
 */
public class LinuxFileParseFactory implements FileParseFactory {

    @Override
    public FileParse createFileParse(FileType fileType) {
        return LinuxSimpleFileParseFactory.getReusableFileParse(fileType);
    }
}
