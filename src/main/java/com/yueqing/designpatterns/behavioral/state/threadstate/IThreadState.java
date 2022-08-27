package com.yueqing.designpatterns.behavioral.state.threadstate;

/**
 * @author dingliming
 * @date 2022/7/20
 */
public interface IThreadState {

    void start();

    void getCpu();

    void releaseCpu();

    void exist();

}
