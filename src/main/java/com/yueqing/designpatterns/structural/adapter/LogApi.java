package com.yueqing.designpatterns.structural.adapter;

/**
 * 适配接口
 *
 * @author dingliming
 * @date 2022/7/19
 */
public interface LogApi {

    void info(String msg);

    void warn(String msg);

    void error(String msg);
}
