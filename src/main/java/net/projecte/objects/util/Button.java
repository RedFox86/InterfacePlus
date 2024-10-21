package net.projecte.objects.util;

import net.projecte.Task;
import net.projecte.objects.RenderableObject;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Button extends RenderableObject {
	private ArrayList<Task> taskList;
	public Button(BufferedImage objectImg, int IX, int IY, ArrayList<Task> renderableObjectTaskList) {
		super(objectImg, IX, IY);
		taskList = renderableObjectTaskList;
	}

	@Override
	public void update(Graphics2D g2) {
		super.update(g2);
		//Implement click detection at some point :shrug:
	}
}