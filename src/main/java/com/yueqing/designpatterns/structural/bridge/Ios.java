package com.yueqing.designpatterns.structural.bridge;

import java.io.File;

/**
 * @author dingliming
 * @date 2022/8/5
 */
public class Ios implements Platform{

    @Override
    public File fileRead(String path) {
        return null;
    }
}
