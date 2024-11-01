package net.projecte.objects.util.animated;

import net.projecte.gui.util.WindowContext;
import net.projecte.objects.util.Panel;

import java.awt.image.BufferedImage;

public class AnimatedPanel extends Panel {
	private final BufferedImage[] imageList;
	private final int maxFrame;
	private final int frameRate;
	private int currentFrame;
	private int frameDelay;
	protected AnimatedPanel(BufferedImage[] animatedPanelImageList, int IX, int IY, int animatedPanelFrameRate) {
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
			displayImage = imageList[currentFrame];
		} else {
			frameDelay++;
		}
		super.update(context);
	}
}
