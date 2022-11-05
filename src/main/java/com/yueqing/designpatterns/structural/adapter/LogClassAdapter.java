package com.yueqing.designpatterns.structural.adapter;

/**
 * 类适配器
 *
 * @author dingliming
 * @date 2022/7/19
 */
public class LogClassAdapter implements LogApi {

    private final ALog aLog;

    public LogClassAdapter(ALog aLog) {
        this.aLog = aLog;
    }

    @Override
    public void info(String msg) {
        aLog.log(msg);
    }

    @Override
    public void warn(String msg) {
        aLog.log(msg, 2);
    }

    @Override
    public void error(String msg) {
        aLog.log(msg, 3);
    }
}
