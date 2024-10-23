package net.projecte;

import net.projecte.objects.RenderableObject;

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