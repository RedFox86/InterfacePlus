package net.redfox.interfaceplus.object;

import net.redfox.interfaceplus.util.BufferedImageManager;
import net.redfox.interfaceplus.gui.display.Interface;

import java.awt.image.BufferedImage;

@SuppressWarnings("unchecked")
public abstract class RenderableObjectBuilder<K extends RenderableObject, T extends RenderableObjectBuilder<K, T>> {
	protected final BufferedImage displayImage;
	protected int x;
	protected int y;
	protected final Interface bInterface;

	/**
	 * @param bInterface The interface that the RenderableObject will be displayed on - used to add to the objects list in Renderer.
	 * @param imagePath The path for the image that will be loaded and displayed on the screen.
	 */
	protected RenderableObjectBuilder(Interface bInterface, String imagePath) {
		this.x = 0;
		this.y = 0;
		this.bInterface = bInterface;
		if (imagePath != null) {
			displayImage = BufferedImageManager.getImage(imagePath);
		} else {
			displayImage = null;
		}
	}
	public abstract T x(int objX);
	public abstract T y(int objY);

	protected T setX(int x) {
		this.x = x;
		return (T)this;
	}
	protected T setY(int y) {
		this.y = y;
		return (T)this;
	}
	protected K build(K k) {
		bInterface.getRenderer().addRenderableObject(k);
		return k;
	}

	/**
	 * @return A RenderableObject built by the builder using the values passed in by mutator methods.
	 */
	public abstract K build();
}