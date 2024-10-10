package net.projecte.objects;

import java.awt.*;
import java.util.ArrayList;

public class Renderer {
	protected ArrayList<RenderableObject> objects;
	public Renderer() {
		 objects = new ArrayList<>();
	}
	public void renderObjects(Graphics2D g2) {
		for (RenderableObject object : objects) {
			object.drawImage(g2);
		}
	}
}