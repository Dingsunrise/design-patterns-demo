package com.yueqing.designpatterns.structural.bridge;

import java.io.File;

/**
 * @author dingliming
 * @date 2022/8/5
 */
public class JsonFileParse extends AbstractFileParse implements FileParse {

    public JsonFileParse(Platform platform) {
        super.platform = platform;
    }

    @Override
    public String fileParse(String filePath) {
        File file = readFile(filePath);
        //deal json
        return null;
    }
}
