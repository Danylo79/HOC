package dev.dankom.hoc.commands.commands;

import dev.dankom.hoc.commands.CommandContext;
import dev.dankom.hoc.commands.ICommand;

public class TestCommand implements ICommand {
    @Override
    public String getName() {
        return "test";
    }

    @Override
    public void handle(CommandContext ctx) {
        ctx.sendMessage("This is a test!");
    }
}
