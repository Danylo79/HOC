package dev.dankom.hoc.commands;

import dev.dankom.hoc.util.ListHelper;

public interface ICommand {
    String getName();
    default String[] getAliases() {
        return ListHelper.toArray("");
    }

    void handle(CommandContext ctx);
}
