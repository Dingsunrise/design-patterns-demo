package com.yueqing.designpatterns.behavioral.command.command;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

/**
 * 宏命令 命令集合
 *
 * @author dingliming
 * @date 2022/7/22
 */
public class MacroCommand {

    private final List<Command> commands = new ArrayList<>();

    public void addCommand(Command command) {
        commands.add(command);
    }

    public void execute(Consumer<Command> consumer) {
        commands.forEach(consumer);
    }
}
