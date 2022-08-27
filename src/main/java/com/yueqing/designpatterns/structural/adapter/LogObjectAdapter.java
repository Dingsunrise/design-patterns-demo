package com.yueqing.designpatterns.structural.adapter;

/**
 * 对象适配器
 *
 * @author dingliming
 * @date 2022/7/19
 */
public class LogObjectAdapter extends ALog implements LogApi {

    @Override
    public void info(String msg) {
        log(msg);
    }

    @Override
    public void warn(String msg) {
        log(msg, 2);
    }

    @Override
    public void error(String msg) {
        log(msg, 3);
    }
}
