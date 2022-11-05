package com.yueqing.designpatterns.behavioral.command.command;

/**
 * @author dingliming
 * @date 2022/7/22
 */
public interface Command {

    void on();

    void off();

    void undo();
}
