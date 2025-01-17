package net.redfox.interfaceplus.object.util.animated;

import net.redfox.interfaceplus.util.BufferedImageManager;
import net.redfox.interfaceplus.util.Logger;
import net.redfox.interfaceplus.gui.display.Interface;
import net.redfox.interfaceplus.object.RenderableObjectBuilder;

import java.awt.image.BufferedImage;

public class AnimatedPanelBuilder extends RenderableObjectBuilder<AnimatedPanel, AnimatedPanelBuilder> {
	private final BufferedImage[] displayImages;
	private int frameRate;
	/**
	 * @param bInterface The interface that the AnimatedPanel will be displayed on - used to add to the objects list in Renderer.
	 * @param displayImages The array of images that will be loaded and displayed on the screen.
	 */
	public AnimatedPanelBuilder(Interface bInterface, String[] displayImages) {
		super(bInterface, displayImages[0]);
		this.displayImages = new BufferedImage[displayImages.length];
		for (int j = 0; j < displayImages.length; j++) {
			this.displayImages[j] = BufferedImageManager.getImage(displayImages[j]);
		}
		frameRate = 10;
	}
	public AnimatedPanelBuilder frameRate(int frameRate) {
		this.frameRate = frameRate;
		return this;
	}

	@Override
	public AnimatedPanelBuilder x(int x) {
		return super.setX(x);
	}

	@Override
	public AnimatedPanelBuilder y(int y) {
		return super.setY(y);
	}

	@Override
	public AnimatedPanel build() {
		Logger.log("Animated Panel successfully built.");
		return super.build(new AnimatedPanel(displayImages, x, y, frameRate));
	}
}
