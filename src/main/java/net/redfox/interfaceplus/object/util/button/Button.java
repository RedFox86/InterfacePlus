package net.redfox.interfaceplus.object.util.button;

import net.redfox.interfaceplus.task.Task;
import net.redfox.interfaceplus.gui.util.MouseHandler;
import net.redfox.interfaceplus.gui.util.WindowContext;
import net.redfox.interfaceplus.object.RenderableObject;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Button extends RenderableObject {
	private final ArrayList<Task> taskList = new ArrayList<>();
	private final BufferedImage hoverImg, clickImg;
	private final BufferedImage defaultImg;
	private final boolean holdTrigger;
	private boolean buttonDown = false;
	protected Button(BufferedImage[] displayImages, int x, int y, boolean holdTrigger) {
		super(displayImages[0], x, y);
		defaultImg = displayImages[0];
		hoverImg = displayImages[1];
		clickImg = displayImages[2];
		this.holdTrigger = holdTrigger;
	}
	protected Button(int width, int height, int x, int y, boolean holdTrigger) {
		super(width, height, x, y);
		defaultImg = null;
		hoverImg = null;
		clickImg = null;
		this.holdTrigger = holdTrigger;
	}
	public void onClick(Task t) {
		taskList.add(t);
	}
	@Override
	public void update(WindowContext context) {
		super.update(context);
		if (MouseHandler.overlaps(this, context)) {
			if (MouseHandler.mouseDown) {
				if (!buttonDown || holdTrigger) {
					buttonDown = true;
					displayImage = clickImg;
					for (Task t : taskList) {
						t.execute();
					}
				}
			} else {
				displayImage = hoverImg;
				buttonDown = false;
			}
		} else {
			displayImage = defaultImg;
		}
	}
}