package net.redfox.interfaceplus.objects.util.button;

import net.redfox.interfaceplus.Task;
import net.redfox.interfaceplus.gui.util.MouseHandler;
import net.redfox.interfaceplus.gui.util.WindowContext;
import net.redfox.interfaceplus.objects.RenderableObject;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Button extends RenderableObject {
	private final ArrayList<Task> taskList = new ArrayList<>();
	private final BufferedImage hoverImg, clickImg;
	private final BufferedImage defaultImg;
	private final boolean holdTrigger;
	private boolean buttonDown = false;
	protected Button(BufferedImage[] objectImgs, int IX, int IY, boolean renderableObjectHoldTrigger) {
		super(objectImgs[0], IX, IY);
		defaultImg = objectImgs[0];
		hoverImg = objectImgs[1];
		clickImg = objectImgs[2];
		holdTrigger = renderableObjectHoldTrigger;
	}
	protected Button(int buttonWidth, int buttonHeight, int IX, int IY, boolean renderableObjectHoldTrigger) {
		super(buttonWidth, buttonHeight, IX, IY);
		defaultImg = null;
		hoverImg = null;
		clickImg = null;
		holdTrigger = renderableObjectHoldTrigger;
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