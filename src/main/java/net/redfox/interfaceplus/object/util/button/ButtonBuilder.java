package net.redfox.interfaceplus.object.util.button;

import net.redfox.interfaceplus.util.BufferedImageManager;
import net.redfox.interfaceplus.util.Logger;
import net.redfox.interfaceplus.gui.display.Interface;
import net.redfox.interfaceplus.object.RenderableObjectBuilder;

import java.awt.image.BufferedImage;

@SuppressWarnings("unused")
public class ButtonBuilder extends RenderableObjectBuilder<Button, ButtonBuilder> {
	private final BufferedImage[] displayImages;
	private boolean holdTrigger;
	/**
	 * @param bInterface The interface that the Button will be displayed on - used to add to the objects list in Renderer.
	 * @param imagePath The path for the image that will be loaded and displayed on the screen.
	 */
	public ButtonBuilder(Interface bInterface, String imagePath) {
		super(bInterface, imagePath);
		displayImages = new BufferedImage[]{displayImage, displayImage, displayImage};
		holdTrigger = false;
	}

	@Override
	public ButtonBuilder x(int x) {
		return super.setX(x);
	}
	@Override
	public ButtonBuilder y(int y) {
		return super.setY(y);
	}
	public ButtonBuilder hoverImg(String imgPath) {
		displayImages[1] = BufferedImageManager.getImage(imgPath);
		return this;
	}
	public ButtonBuilder clickImg(String imgPath) {
		displayImages[2] = BufferedImageManager.getImage(imgPath);
		return this;
	}
	public ButtonBuilder hold() {
		holdTrigger = true;
		return this;
	}
	@Override
	public Button build() {
		Logger.log("Button successfully built.");
		return super.build(new Button(displayImages, x, y, holdTrigger));
	}
}