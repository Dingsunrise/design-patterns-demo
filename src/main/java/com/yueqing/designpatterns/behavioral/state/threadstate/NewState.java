package com.yueqing.designpatterns.behavioral.state.threadstate;

/**
 * @author dingliming
 * @date 2022/7/20
 */
public class NewState extends AbstractThreadState implements IThreadState{

    public NewState(ThreadDemo threadDemo) {
        super.threadDemo = threadDemo;
    }

    @Override
    public void start() {
        System.out.println("thead is start");
        threadDemo.setState(new RunnableState(threadDemo));
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
        existOperation();
    }
}
