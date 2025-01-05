package net.redfox.interfaceplus.object;

import net.redfox.interfaceplus.gui.util.WindowContext;

import java.util.ArrayList;

public class Renderer {
	private final ArrayList<RenderableObject> objects;
	private final ArrayList<RenderableObject> toAdd;
	public Renderer() {
		 objects = new ArrayList<>();
		 toAdd = new ArrayList<>();
	}
	public void renderObjects(WindowContext context) {
		if (!toAdd.isEmpty()) {
			objects.addAll(toAdd);
			toAdd.clear();
		}
		for (RenderableObject object : objects) {
			object.update(context);
		}
	}
	public void addRenderableObject(RenderableObject r) {
		toAdd.add(r);
	}
}