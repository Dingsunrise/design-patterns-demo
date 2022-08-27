package com.yueqing.designpatterns.behavioral.command;

/**
 * @author dingliming
 * @date 2022/7/22
 */
public enum CommandState {
    ON,OFF,UNLOAD;

    public boolean isOn(){
        return ON.equals(this);
    }

    public boolean isOff(){
        return OFF.equals(this);
    }
}
