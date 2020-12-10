package dev.dankom;

import dev.dankom.hoc.Main;
import dev.dankom.hoc.file.FileManager;
import dev.dankom.hoc.logger.LogLevel;
import dev.dankom.hoc.logger.Logger;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;

import javax.security.auth.login.LoginException;

public class Start {

    private static FileManager fileManager;

    public static void main(String[] args) {
        fileManager = new FileManager();

        if (!fileManager.privateFile.isGenerated()) {
            Logger.log(LogLevel.ERROR, "private.json not generated! Add the token and try again!");
            fileManager.privateFile.generateConfig();
            Runtime.getRuntime().exit(-1);
        }

        try {
            new FileManager();
            JDA jda = JDABuilder.createDefault((String) fileManager.privateFile.getConfig().get("token")).build();
            new Main(jda);
        } catch (LoginException e) {
            e.printStackTrace();
        }
    }
}
