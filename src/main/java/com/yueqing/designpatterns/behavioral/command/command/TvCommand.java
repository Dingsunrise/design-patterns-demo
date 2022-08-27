package com.yueqing.designpatterns.behavioral.command.command;

import com.yueqing.designpatterns.behavioral.command.CommandState;
import com.yueqing.designpatterns.behavioral.command.handle.TvService;

/**
 * @author dingliming
 * @date 2022/7/22
 */
public class TvCommand extends AbstractCommand {

    private final TvService tvService;

    public TvCommand(TvService tvService) {
        this.tvService = tvService;
    }

    @Override
    public void on() {
        tvService.turnOnTv();
        saveCommandState(CommandState.ON);
    }

    @Override
    public void off() {
        tvService.turnOffTv();
        saveCommandState(CommandState.OFF);
    }
}
