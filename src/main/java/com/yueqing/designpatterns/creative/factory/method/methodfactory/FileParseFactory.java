package com.yueqing.designpatterns.creative.factory.method.methodfactory;

import com.yueqing.example.parse.FileParse;
import com.yueqing.example.parse.FileType;

/**
 * @author dingliming
 * @date 2022/7/5
 */
public interface FileParseFactory {

    FileParse createFileParse(FileType fileType);
}
