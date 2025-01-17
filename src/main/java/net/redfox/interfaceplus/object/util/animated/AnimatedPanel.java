package net.redfox.interfaceplus.object.util.animated;

import net.redfox.interfaceplus.gui.util.WindowContext;
import net.redfox.interfaceplus.object.util.Panel;

import java.awt.image.BufferedImage;

public class AnimatedPanel extends Panel {
	private final BufferedImage[] displayImages;
	private final int maxFrame;
	private final int frameRate;
	private int currentFrame;
	private int frameDelay;
	protected AnimatedPanel(BufferedImage[] displayImages, int x, int y, int frameRate) {
		super(displayImages[0], x, y);
		this.displayImages = displayImages;
		maxFrame = this.displayImages.length;
		this.frameRate = frameRate;
	}
	@Override
	public void update(WindowContext context) {
		if (frameDelay == frameRate) {
			frameDelay = 0;
			if (currentFrame == maxFrame-1) {
				currentFrame = 0;
			} else {
				currentFrame++;
			}
			displayImage = displayImages[currentFrame];
		} else {
			frameDelay++;
		}
		super.update(context);
	}
}
