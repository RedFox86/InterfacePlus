package net.redfox.interfaceplus.util;

import java.time.LocalDateTime;
import java.util.function.Supplier;

public class Logger {
	private static final Supplier<String> time = () -> {
		LocalDateTime now = LocalDateTime.now();
		return now.getHour() + ":" + now.getMinute() + ":" + now.getSecond();
	};
	public static void log(String message) {
		System.out.println(time.get() + "/LOG/" + message);
	}
	public static void warn(String message) {
		System.out.println(time.get() + "/WARN/" + message);
	}
	public static void error(String message) {
		System.out.println(time.get() + "/ERROR/" + message);
	}
}