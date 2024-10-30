package net.projecte.objects.util.button;

import net.projecte.BufferedImageManager;
import net.projecte.Logger;
import net.projecte.gui.display.Interface;
import net.projecte.objects.RenderableObjectBuilder;

import java.awt.image.BufferedImage;

@SuppressWarnings("unused")
public class ButtonBuilder extends RenderableObjectBuilder<Button, ButtonBuilder> {
	private final BufferedImage[] imgs;
	private boolean holdTrigger = false;
	public ButtonBuilder(Interface i, String imgPath) {
		super(i, imgPath);
		imgs = new BufferedImage[]{img, img, img};
	}
	@Override
	public ButtonBuilder y(int objY) {
		return super.setY(objY);
	}
	@Override
	public ButtonBuilder x(int objX) {
		return super.setX(objX);
	}
	public ButtonBuilder hoverImg(String imgPath) {
		imgs[1] = BufferedImageManager.getImage(imgPath);
		return this;
	}
	public ButtonBuilder clickImg(String imgPath) {
		imgs[2] = BufferedImageManager.getImage(imgPath);
		return this;
	}
	public ButtonBuilder hold() {
		holdTrigger = true;
		return this;
	}
	@Override
	public Button build() {
		Logger.log("Button successfully built.");
		return super.build(new Button(imgs, x, y, holdTrigger));
	}
}
