package net.redfox.interfaceplus.object.util.animated;

import net.redfox.interfaceplus.util.BufferedImageManager;
import net.redfox.interfaceplus.util.Logger;
import net.redfox.interfaceplus.gui.display.Interface;
import net.redfox.interfaceplus.object.RenderableObjectBuilder;

import java.awt.image.BufferedImage;

public class NodePanelBuilder extends RenderableObjectBuilder<NodePanel, NodePanelBuilder> {
	private final BufferedImage[] displayImages;
	private boolean repeat;
	/**
	 * @param bInterface The interface that the NodePanel will be displayed on - used to add to the objects list in Renderer.
	 * @param displayImages The array of images that will be loaded and displayed on the screen.
	 */
	public NodePanelBuilder(Interface bInterface, String[] displayImages) {
		super(bInterface, displayImages[0]);
		this.displayImages = new BufferedImage[displayImages.length];
		for (int j = 0; j < displayImages.length; j++) {
			this.displayImages[j] = BufferedImageManager.getImage(displayImages[j]);
		}
		repeat = true;
	}
	public NodePanelBuilder repeat(boolean repeat) {
		this.repeat = repeat;
		return this;
	}

	@Override
	public NodePanelBuilder x(int objX) {
		return super.setX(objX);
	}

	@Override
	public NodePanelBuilder y(int objY) {
		return super.setY(objY);
	}

	@Override
	public NodePanel build() {
		Logger.log("Node Panel successfully built.");
		return super.build(new NodePanel(displayImages, x, y, repeat));
	}
}
