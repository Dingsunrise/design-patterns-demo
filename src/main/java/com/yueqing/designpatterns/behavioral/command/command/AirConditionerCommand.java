package com.yueqing.designpatterns.behavioral.command.command;

import com.yueqing.designpatterns.behavioral.command.CommandState;
import com.yueqing.designpatterns.behavioral.command.handle.AirConditionerService;

/**
 * @author dingliming
 * @date 2022/7/22
 */
public class AirConditionerCommand extends AbstractCommand {

    private final AirConditionerService airConditionerService;

    public AirConditionerCommand(AirConditionerService airConditionerService) {
        this.airConditionerService = airConditionerService;
    }

    @Override
    public void on() {
        airConditionerService.turnOnAirConditioner();
        saveCommandState(CommandState.ON);
    }

    @Override
    public void off() {
        airConditionerService.turnOffAirConditioner();
        saveCommandState(CommandState.OFF);
    }
}
