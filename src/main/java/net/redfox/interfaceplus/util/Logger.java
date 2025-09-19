package net.redfox.interfaceplus.util;

import java.time.LocalDateTime;
import java.util.function.Supplier;

public class Logger {
	private static final String RED_ANSI = "\u001B[31m";
	private static final String ANSI_RESET = "\u001B[0m";

	private String name;

	private final Supplier<String> time = () -> {
		LocalDateTime now = LocalDateTime.now();
		String hours = (now.getHour() >= 10) ? ""+now.getHour() : "0"+now.getHour();
		String minutes = (now.getMinute() >= 10) ? ""+now.getMinute() : "0"+now.getMinute();
		String seconds = (now.getSecond() >= 10) ? ""+now.getSecond() : "0"+now.getSecond();
		return hours + ":" + minutes + ":" + seconds;
	};

	public Logger(String name) {
		this.name = name;
	}

	public void info(String message) {
		System.out.println(time.get() + "/" + name + "/INFO/" + message);
	}
	public void warn(String message) {
		System.out.println(RED_ANSI + time.get() + "/" + name + "/WARN/" + message + ANSI_RESET);
	}
	public void error(String message) {
		System.out.println(RED_ANSI + time.get() + "/" + name + "/ERROR/" + message + ANSI_RESET);
	}
}