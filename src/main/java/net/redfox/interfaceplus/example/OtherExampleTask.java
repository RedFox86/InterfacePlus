package net.redfox.interfaceplus.example;

import net.redfox.interfaceplus.object.util.animated.NodePanel;
import net.redfox.interfaceplus.task.Task;

public class OtherExampleTask implements Task {
	private final NodePanel object;
	public OtherExampleTask(NodePanel r) {
		object = r;
	}
	@Override
	public void execute() {
		object.next();
	}
}