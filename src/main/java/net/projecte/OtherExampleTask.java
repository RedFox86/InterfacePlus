package net.projecte;

import net.projecte.objects.RenderableObject;
import net.projecte.objects.util.animated.NodePanel;

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