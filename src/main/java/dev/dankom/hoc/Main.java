package dev.dankom.hoc;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.Activity;

public class Main {
    private JDA jda;

    public Main(JDA jda) {
        this.jda = jda;

        jda.getPresence().setActivity(Activity.watching("Danylo is the best!"));
    }
}
