package net.projecte.objects;

import net.projecte.BufferedImageManager;
import net.projecte.gui.display.Interface;

import java.awt.image.BufferedImage;

@SuppressWarnings("unchecked")
public abstract class RenderableObjectBuilder<K extends RenderableObject, T extends RenderableObjectBuilder<K, T>> {
	protected final BufferedImage displayImage;
	protected int x;
	protected int y;
	protected final Interface builderInterface;

	/**
	 * @param renderableObjectBuilderInterface The interface that the RenderableObject will be displayed on - used to add to the objects list in Renderer.
	 * @param imagePath The path for the image that will be loaded and displayed on the screen.
	 */
	protected RenderableObjectBuilder(Interface renderableObjectBuilderInterface, String imagePath) {
		this.x = 0;
		this.y = 0;
		builderInterface = renderableObjectBuilderInterface;
		if (imagePath != null) {
			displayImage = BufferedImageManager.getImage(imagePath);
		} else {
			displayImage = null;
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
		builderInterface.getRenderer().addRenderableObject(k);
		return k;
	}

	/**
	 * @return A RenderableObject built by the builder using the values passed in by mutator methods.
	 */
	public abstract K build();
}