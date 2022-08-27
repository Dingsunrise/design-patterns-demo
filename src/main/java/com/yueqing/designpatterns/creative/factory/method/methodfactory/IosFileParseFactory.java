package com.yueqing.designpatterns.creative.factory.method.methodfactory;

import com.yueqing.designpatterns.creative.factory.simple.IosSimpleFileParseFactory;
import com.yueqing.example.parse.FileParse;
import com.yueqing.example.parse.FileType;

/**
 * @author dingliming
 * @date 2022/7/16
 */
public class IosFileParseFactory implements FileParseFactory {

    @Override
    public FileParse createFileParse(FileType fileType) {
        return IosSimpleFileParseFactory.getReusableFileParse(fileType);
    }
}
