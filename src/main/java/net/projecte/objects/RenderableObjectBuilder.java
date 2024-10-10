package net.projecte.objects;

import net.projecte.BufferedImageManager;
import net.projecte.gui.Interface;

import java.awt.image.BufferedImage;

public class RenderableObjectBuilder {
	private final BufferedImage img;
	private int x;
	private int y;
	private final Interface bInterface;
	public RenderableObjectBuilder(Interface i, String imgPath) {
		this.x = 0;
		this.y = 0;
		bInterface = i;
		img = BufferedImageManager.getImage(imgPath);
	}
	public RenderableObjectBuilder x(int objX) {
		this.x = objX;
		return this;
	}
	public RenderableObjectBuilder y(int objY) {
		this.y = objY;
		return this;
	}
	public RenderableObject build() {
		RenderableObject r = new RenderableObject(img, x, y);
		bInterface.getRenderer().objects.add(r);
		return r;
	}
}