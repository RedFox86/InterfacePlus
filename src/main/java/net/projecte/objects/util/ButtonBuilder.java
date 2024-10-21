package net.projecte.objects.util;

import net.projecte.Task;
import net.projecte.gui.Interface;
import net.projecte.objects.RenderableObjectBuilder;

import java.util.ArrayList;

public class ButtonBuilder extends RenderableObjectBuilder<Button, ButtonBuilder> {
	private ArrayList<Task> taskList = new ArrayList<>();
	public ButtonBuilder(Interface i, String imgPath) {
		super(i, imgPath);
	}
	@Override
	public ButtonBuilder y(int objY) {
		return super.setY(objY);
	}
	@Override
	public ButtonBuilder x(int objX) {
		return super.setX(objX);
	}
	public ButtonBuilder onClick(Task t) {
		taskList.add(t);
		return this;
	}
	@Override
	public Button build() {
		return super.render(new Button(img, x, y, taskList));
	}
}
