package dev.dankom.hoc.commands;

import dev.dankom.hoc.Main;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.MessageEmbed;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

import java.util.List;

public class CommandContext {
    public final CommandManager commandManager;
    public final MessageReceivedEvent event;
    public final List<String> args;

    public CommandContext(CommandManager commandManager, MessageReceivedEvent event, List<String> args) {
        this.commandManager = commandManager;
        this.event = event;
        this.args = args;
    }

    public void sendMessage(String msg) {
        event.getChannel().sendMessage(msg).queue();
    }

    public void sendMessage(MessageEmbed msg) {
        event.getChannel().sendMessage(msg).queue();
    }

    public JDA getJDA() {
        return Main.getJDA();
    }

    public Message getMessage() {
        return event.getMessage();
    }

    public CommandManager getCommandManager() {
        return commandManager;
    }
}
