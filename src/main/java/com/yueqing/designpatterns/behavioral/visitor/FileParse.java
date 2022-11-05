package com.yueqing.designpatterns.behavioral.visitor;

import java.io.File;

/**
 * @author dingliming
 * @date 2022/7/4
 */
public interface FileParse {

    String parse(File file);

    void accept(Visitor visitor);
}
