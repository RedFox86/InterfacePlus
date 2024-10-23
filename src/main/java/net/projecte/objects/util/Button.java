package net.projecte.objects.util;

import net.projecte.Task;
import net.projecte.gui.util.MouseHandler;
import net.projecte.gui.util.WindowContext;
import net.projecte.objects.RenderableObject;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Button extends RenderableObject {
	private final ArrayList<Task> taskList;
	private final BufferedImage hoverImg, clickImg;
	private final BufferedImage defaultImg;
	public Button(BufferedImage[] objectImgs, int IX, int IY, ArrayList<Task> renderableObjectTaskList) {
		super(objectImgs[0], IX, IY);
		defaultImg = objectImgs[0];
		hoverImg = objectImgs[1];
		clickImg = objectImgs[2];
		taskList = renderableObjectTaskList;
	}

	@Override
	public void update(WindowContext context) {
		super.update(context);
		if (MouseHandler.overlaps(this, context)) {
			if (MouseHandler.mouseDown) {
				displayImg = clickImg;
				for (Task t : taskList) {
					t.execute();
				}
			} else {
				displayImg = hoverImg;
			}
		} else {
			displayImg = defaultImg;
		}
	}
}