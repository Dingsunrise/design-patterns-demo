package com.yueqing.designpatterns.structural.adapter;

/**
 * 待适配对象
 *
 * @author dingliming
 * @date 2022/7/19
 */
public class ALog {

    public void log(String msg) {
        log(msg, 1);
    }

    public void log(String msg, Integer level) {
        System.out.println("level: " + level + " msg:" + msg);
    }
}
