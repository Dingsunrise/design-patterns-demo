package com.yueqing.designpatterns.behavioral.state;

import com.yueqing.designpatterns.behavioral.state.threadstate.ThreadDemo;

/**
 * @author dingliming
 * @date 2022/7/20
 */
public class StateTest {

    public static void main(String[] args) {
        ThreadDemo thread = new ThreadDemo();
        thread.start();
        thread.getCpu();
        thread.releaseCpu();
        thread.exist();
        thread.start();
    }

}
