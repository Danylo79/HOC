package dev.dankom.hoc.commands.commands;

import dev.dankom.hoc.commands.CommandContext;
import dev.dankom.hoc.commands.ICommand;
import dev.dankom.hoc.util.ListHelper;

public class HelpCommand implements ICommand {
    @Override
    public String getName() {
        return "help";
    }

    @Override
    public String[] getHelps() {
        return ListHelper.toArray("~help: Shows all commands", "~help [command]: Shows the help message for the passed in command");
    }

    @Override
    public void handle(CommandContext ctx) {
        try {
            if (ctx.commandManager.commands.contains(ctx.commandManager.getCommand(ctx.args.get(0)))) {
                ICommand command = ctx.commandManager.getCommand(ctx.args.get(0));
                if (command.getHelps() == null) {
                    ctx.sendMessage(command.getName() + ": " + command.getHelp());
                } else {
                    for (String s : command.getHelps()) {
                        ctx.sendMessage(command.getName() + ": " + s);
                    }
                }
            }
        } catch (IndexOutOfBoundsException e) {
            for (ICommand command : ctx.commandManager.commands) {
                if (command.getHelps() == null) {
                    ctx.sendMessage(command.getName() + ": " + command.getHelp());
                } else {
                    for (String s : command.getHelps()) {
                        ctx.sendMessage(command.getName() + ": " + s);
                    }
                }
            }
        }
    }
}
