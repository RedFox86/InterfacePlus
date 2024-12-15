package net.redfox.interfaceplus;

import java.time.LocalDateTime;
import java.util.function.Supplier;

public class Logger {
	static Supplier<String> time = () -> {
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