package dev.dankom.hoc.logger;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Logger {
    public static void log(Object msg) {
        log(LogLevel.INFO.getColor(), LogLevel.INFO.getName(), msg);
    }

    public static void log(LogLevel logLevel, Object msg) {
        log(logLevel.getColor(), logLevel.getName(), msg);
    }

    private static void log(String color, String loglevel, Object msg) {
        DateFormat dateFormat = new SimpleDateFormat("hh:mm:ss");
        String TIME = dateFormat.format(new Date(System.currentTimeMillis()));

        System.out.println(color + "[" + TIME + "] HOC: " + "[" + loglevel + "] " + msg);
        if (loglevel.equalsIgnoreCase("FATAL")) {
            Runtime.getRuntime().exit(0);
        }
    }
}
