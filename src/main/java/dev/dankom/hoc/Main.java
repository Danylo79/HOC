package dev.dankom.hoc;

import dev.dankom.hoc.listeners.CommandListener;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.Activity;

public class Main {
    private static JDA jda;

    public Main(JDA jda) {
        this.jda = jda;

        //Register Listeners
        jda.addEventListener(new CommandListener());
        //------------------
        jda.getPresence().setActivity(Activity.watching("Danylo is the best!"));
    }

    public static JDA getJDA() {
        return jda;
    }
}
