package net.redfox.interfaceplus.object.util.animated;

import net.redfox.interfaceplus.object.RenderableObject;

import java.awt.image.BufferedImage;

public class NodePanel extends RenderableObject {
	private final BufferedImage[] imageList;
	private int currentFrame = 0;
	private final boolean repeat;
	protected NodePanel(BufferedImage[] nodePanelImageList, int IX, int IY, boolean nodePanelRepeat) {
		super(nodePanelImageList[0], IX, IY);
		imageList = nodePanelImageList;
		repeat = nodePanelRepeat;
	}
	public void next() {
		if (currentFrame == imageList.length-1) {
			if (repeat) {
				currentFrame = 0;
			}
		} else {
			currentFrame++;
		}
		displayImage = imageList[currentFrame];
	}
}