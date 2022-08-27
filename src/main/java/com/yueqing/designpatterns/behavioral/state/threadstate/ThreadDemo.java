package com.yueqing.designpatterns.behavioral.state.threadstate;

import lombok.Data;

/**
 * @author dingliming
 * @date 2022/7/20
 */
@Data
public class ThreadDemo implements IThreadState{

    private IThreadState state;

    public ThreadDemo() {
        this.state = new NewState(this);
    }

    @Override
    public void start() {
        this.state.start();
    }

    @Override
    public void getCpu() {
        this.state.getCpu();
    }

    @Override
    public void releaseCpu() {
        this.state.releaseCpu();
    }

    @Override
    public void exist() {
        this.state.exist();
    }
}
