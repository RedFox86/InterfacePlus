package net.redfox.interfaceplus;

import net.redfox.interfaceplus.object.RenderableObject;
import net.redfox.interfaceplus.task.Task;

public class ExampleTask implements Task {
	private final RenderableObject object;
	public ExampleTask(RenderableObject r) {
		object = r;
	}
	@Override
	public void execute() {
		object.setX(object.getX()+1);
	}
}