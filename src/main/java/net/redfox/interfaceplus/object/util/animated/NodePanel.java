package net.redfox.interfaceplus.object.util.animated;

import net.redfox.interfaceplus.object.RenderableObject;

import java.awt.image.BufferedImage;

public class NodePanel extends RenderableObject {
	private final BufferedImage[] displayImages;
	private int currentFrame = 0;
	private final boolean repeat;
	protected NodePanel(BufferedImage[] displayImages, int x, int y, boolean repeat) {
		super(displayImages[0], x, y);
		this.displayImages = displayImages;
		this.repeat = repeat;
	}
	public void next() {
		if (currentFrame == displayImages.length-1) {
			if (repeat) {
				currentFrame = 0;
			}
		} else {
			currentFrame++;
		}
		displayImage = displayImages[currentFrame];
	}
}