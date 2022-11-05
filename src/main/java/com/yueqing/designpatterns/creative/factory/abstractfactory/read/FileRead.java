package com.yueqing.designpatterns.creative.factory.abstractfactory.read;

import java.io.File;

/**
 * @author dingliming
 * @date 2022/7/16
 */
public interface FileRead {

    File readFile(String path);
}
