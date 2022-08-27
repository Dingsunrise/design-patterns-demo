package com.yueqing.designpatterns.behavioral.state.threadstate;

/**
 * @author dingliming
 * @date 2022/7/20
 */
public class RunningState extends AbstractThreadState implements IThreadState{

    public RunningState(ThreadDemo threadDemo) {
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
        System.out.println("this thread is blocked");
        super.threadDemo.setState(new BlockedState(threadDemo));
    }

    @Override
    public void exist() {
        existOperation();
    }
}
