package net.projecte.objects;

import net.projecte.BufferedImageManager;
import net.projecte.Logger;
import net.projecte.gui.display.Interface;

import java.awt.image.BufferedImage;

@SuppressWarnings("unchecked")
public abstract class RenderableObjectBuilder<K extends RenderableObject, T extends RenderableObjectBuilder<K, T>> {
	protected final BufferedImage img;
	protected int x;
	protected int y;
	protected final Interface bInterface;
	protected RenderableObjectBuilder(Interface i, String imgPath) {
		this.x = 0;
		this.y = 0;
		bInterface = i;
		if (imgPath != null) {
			img = BufferedImageManager.getImage(imgPath);
		} else {
			img = null;
		}
	}
	public abstract T x(int objX);
	public abstract T y(int objY);

	protected T setX(int objX) {
		this.x = objX;
		return (T)this;
	}
	protected T setY(int objY) {
		this.y = objY;
		return (T)this;
	}
	protected K build(K k) {
		bInterface.getRenderer().objects.add(k);
		return k;
	}

	public abstract K build();
}