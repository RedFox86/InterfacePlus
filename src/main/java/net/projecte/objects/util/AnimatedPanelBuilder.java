package net.projecte.objects.util;

import net.projecte.BufferedImageManager;
import net.projecte.Logger;
import net.projecte.gui.display.Interface;
import net.projecte.objects.RenderableObjectBuilder;

import java.awt.image.BufferedImage;

public class AnimatedPanelBuilder extends RenderableObjectBuilder<AnimatedPanel, AnimatedPanelBuilder> {
	private final BufferedImage[] imageList;
	private int frameRate;
	public AnimatedPanelBuilder(Interface i, String[] animatedPanelImageList) {
		super(i, animatedPanelImageList[0]);
		imageList = new BufferedImage[animatedPanelImageList.length];
		for (int j = 0; j < animatedPanelImageList.length; j++) {
			imageList[j] = BufferedImageManager.getImage(animatedPanelImageList[j]);
		}
	}
	public AnimatedPanelBuilder framerate(int value) {
		frameRate = value;
		return this;
	}

	@Override
	public AnimatedPanelBuilder x(int objX) {
		return super.setX(objX);
	}

	@Override
	public AnimatedPanelBuilder y(int objY) {
		return super.setY(objY);
	}

	@Override
	public AnimatedPanel build() {
		Logger.log("Animated Panel successfully built.");
		return super.build(new AnimatedPanel(x, y, imageList, frameRate));
	}
}
