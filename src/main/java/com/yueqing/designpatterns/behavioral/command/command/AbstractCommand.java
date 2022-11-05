package com.yueqing.designpatterns.behavioral.command.command;

import java.util.Objects;

import com.yueqing.designpatterns.behavioral.command.CommandState;

/**
 * @author dingliming
 * @date 2022/7/22
 */
public abstract class AbstractCommand implements Command {

    protected CommandState preState;

    protected void saveCommandState(CommandState state){
        preState = state;
    }

    public abstract void on();

    public abstract void off();

    @Override
    public void undo() {
        if(Objects.isNull(preState)){
            System.out.println("no command to execute");
            return;
        }
        if(preState.isOn()){
            off();
            return;
        }
        if(preState.isOff()){
            on();
            return;
        }
        System.out.println("no command to execute");
    }
}
