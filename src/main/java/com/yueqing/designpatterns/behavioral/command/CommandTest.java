package com.yueqing.designpatterns.behavioral.command;

import com.yueqing.designpatterns.behavioral.command.command.AirConditionerCommand;
import com.yueqing.designpatterns.behavioral.command.command.Command;
import com.yueqing.designpatterns.behavioral.command.command.LightCommand;
import com.yueqing.designpatterns.behavioral.command.command.MacroCommand;
import com.yueqing.designpatterns.behavioral.command.command.TvCommand;
import com.yueqing.designpatterns.behavioral.command.handle.AirConditionerService;
import com.yueqing.designpatterns.behavioral.command.handle.LightService;
import com.yueqing.designpatterns.behavioral.command.handle.TvService;

/**
 * @author dingliming
 * @date 2022/7/22
 */
public class CommandTest {

    public static void main(String[] args) {
        TvService tvService = new TvService();
        Command tvCommand = new TvCommand(tvService);
        tvCommand.on();
        tvCommand.off();
        tvCommand.undo();

        AirConditionerService airConditionerService = new AirConditionerService();
        Command airConditionerCommand = new AirConditionerCommand(airConditionerService);

        LightService lightService = new LightService();
        Command lightCommand = new LightCommand(lightService);

        MacroCommand command = new MacroCommand();
        command.addCommand(tvCommand);
        command.addCommand(lightCommand);
        command.addCommand(airConditionerCommand);

        command.execute(Command::on);
        command.execute(Command::off);
        command.execute(Command::undo);
    }

}
