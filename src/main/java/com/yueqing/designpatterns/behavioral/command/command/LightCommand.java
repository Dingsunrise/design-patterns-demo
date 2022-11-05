package com.yueqing.designpatterns.behavioral.command.command;

import com.yueqing.designpatterns.behavioral.command.CommandState;
import com.yueqing.designpatterns.behavioral.command.handle.LightService;

/**
 * @author dingliming
 * @date 2022/7/22
 */
public class LightCommand extends AbstractCommand {

    private final LightService lightService;

    public LightCommand(LightService lightService) {
        this.lightService = lightService;
    }

    @Override
    public void on() {
        lightService.turnOnLight();
        saveCommandState(CommandState.ON);
    }

    @Override
    public void off() {
        lightService.turnOffLight();
        saveCommandState(CommandState.OFF);
    }
}
