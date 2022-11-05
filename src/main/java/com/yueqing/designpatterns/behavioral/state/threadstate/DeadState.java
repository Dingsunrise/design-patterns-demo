package com.yueqing.designpatterns.behavioral.state.threadstate;

/**
 * @author dingliming
 * @date 2022/7/20
 */
public class DeadState extends AbstractThreadState implements IThreadState {

    public DeadState(ThreadDemo threadDemo) {
        super.threadDemo = threadDemo;
    }

    @Override
    public void start() {
        invalidOperation();
    }

    @Override
    public void getCpu() {
        invalidOperation();
    }

    @Override
    public void releaseCpu() {
        invalidOperation();
    }

    @Override
    public void exist() {
        invalidOperation();
    }
}
