package net.projecte.objects.util;

import net.projecte.gui.util.WindowContext;

import java.awt.image.BufferedImage;

public class AnimatedPanel extends Panel {
	private final BufferedImage[] imageList;
	private final int maxFrame;
	private final int frameRate;
	private int currentFrame;
	private int frameDelay;
	public AnimatedPanel(int IX, int IY, BufferedImage[] animatedPanelImageList, int animatedPanelFrameRate) {
		super(animatedPanelImageList[0], IX, IY);
		imageList = animatedPanelImageList;
		maxFrame = imageList.length;
		frameRate = animatedPanelFrameRate;
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
			displayImg = imageList[currentFrame];
		} else {
			frameDelay++;
		}
		super.update(context);
	}
}
