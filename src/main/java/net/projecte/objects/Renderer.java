package net.projecte.objects;

import net.projecte.gui.util.WindowContext;

import java.util.ArrayList;

public class Renderer {
	public ArrayList<RenderableObject> objects;
	public Renderer() {
		 objects = new ArrayList<>();
	}
	public void renderObjects(WindowContext context) {
		for (RenderableObject object : objects) {
			object.update(context);
		}
	}
}