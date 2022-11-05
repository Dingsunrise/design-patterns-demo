package com.yueqing.designpatterns.structural.bridge;

import java.io.File;

/**
 * @author dingliming
 * @date 2022/8/5
 */
public abstract class AbstractFileParse {

    protected Platform platform;

    protected File readFile(String path){
        return platform.fileRead(path);
    }
}
