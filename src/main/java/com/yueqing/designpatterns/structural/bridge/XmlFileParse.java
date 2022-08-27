package com.yueqing.designpatterns.structural.bridge;

import java.io.File;

/**
 * @author dingliming
 * @date 2022/8/5
 */
public class XmlFileParse extends AbstractFileParse implements FileParse {

    public XmlFileParse(Platform platform) {
        super.platform = platform;
    }

    @Override
    public String fileParse(String filePath) {
        File file = readFile(filePath);
        //deal xml
        return null;
    }
}
