package com.yueqing.designpatterns.behavioral.state.threadstate;

/**
 * @author dingliming
 * @date 2022/7/20
 */
public abstract class AbstractThreadState {

    protected ThreadDemo threadDemo;

    protected void invalidOperation(){
        System.out.println("invalid operation");
    }

    protected void existOperation(){
        System.out.println("thead is ended");
        threadDemo.setState(new DeadState(threadDemo));
    }

}
