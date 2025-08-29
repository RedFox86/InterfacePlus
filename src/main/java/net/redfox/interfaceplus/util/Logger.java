package net.redfox.interfaceplus.util;

import java.time.LocalDateTime;
import java.util.function.Supplier;

public class Logger {
    private static final Supplier<String> time =
            () -> {
                String clock = "";
                LocalDateTime now = LocalDateTime.now();
                int second = now.getSecond();
                int minute = now.getMinute();
                int hour = now.getHour();
                clock += (hour < 10) ? "0" + hour + ":" : hour + ":";
                clock += minute < 10 ? "0" + minute + ":" : minute + ":";
                clock += second < 10 ? "0" + second : second;
                return clock;
            };

    public static void log(String message) {
        System.out.println(time.get() + "/LOG/" + message);
    }

    public static void warn(String message) {
        System.out.println(time.get() + "/WARN/" + message);
    }

    public static void error(String message) {
        System.err.println(time.get() + "/ERROR/" + message);
    }
}
