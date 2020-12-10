package dev.dankom.hoc.commands;

import dev.dankom.hoc.commands.commands.MathCommand;
import dev.dankom.hoc.commands.commands.TestCommand;
import dev.dankom.hoc.util.ListHelper;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class CommandManager {
    public List<ICommand> commands = new ArrayList<>();
    public static String PREFIX = "~";

    public CommandManager() {
        addCommand(new TestCommand());
        addCommand(new MathCommand());
    }

    public void addCommand(ICommand command) {
        if (!commands.contains(command)) {
            commands.add(command);
        }
    }

    @Nullable
    private ICommand getCommand(String search) {
        String searchLower = search.toLowerCase();

        for (ICommand cmd : this.commands) {
            if ((cmd != null && cmd.getName().equals(searchLower)) || (cmd.getAliases() != null && ListHelper.contains(cmd.getAliases(), searchLower))) {
                return cmd;
            }
        }

        return null;
    }

    public void handle(MessageReceivedEvent e) {
        String[] split = e.getMessage().getContentRaw()
                .replaceFirst("(?i)" + Pattern.quote(PREFIX), "")
                .split("\\s+");

        String invoke = split[0].toLowerCase();
        ICommand cmd = this.getCommand(invoke);

        if (cmd != null) {
            e.getChannel().sendTyping().queue();
            List<String> args = Arrays.asList(split).subList(1, split.length);

            CommandContext ctx = new CommandContext(this, e, args);

            cmd.handle(ctx);
        }
    }
}
