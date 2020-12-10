package dev.dankom.hoc.commands;

import dev.dankom.hoc.util.ListHelper;

public interface ICommand {
    String getName();
    default String getHelp() { return null; }
    default String[] getHelps() { return null; }
    default String[] getAliases() {
        return ListHelper.toArray("");
    }

    void handle(CommandContext ctx);
}
