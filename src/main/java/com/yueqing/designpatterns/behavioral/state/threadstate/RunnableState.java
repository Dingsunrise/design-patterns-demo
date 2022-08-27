package com.yueqing.designpatterns.behavioral.state.threadstate;

/**
 * @author dingliming
 * @date 2022/7/20
 */
public class RunnableState extends AbstractThreadState implements IThreadState {

    public RunnableState(ThreadDemo threadDemo) {
        super.threadDemo = threadDemo;
    }

    @Override
    public void start() {
        invalidOperation();
    }

    @Override
    public void getCpu() {
        System.out.println("thead is running");
        threadDemo.setState(new RunningState(threadDemo));
    }

    @Override
    public void releaseCpu() {
        invalidOperation();
    }

    @Override
    public void exist() {
        existOperation();
    }
}
