package com.yueqing.designpatterns.behavioral.iterator;


/**
 * @author dingliming
 * @date 2022/8/7
 */
public interface Iterator {

    boolean hasNext();

    Category next();

    void remove();
}
