package net.redfox.interfaceplus.object.util;

import net.redfox.interfaceplus.object.RenderableObject;

import java.awt.image.BufferedImage;

public class Panel extends RenderableObject {
	/**
	 *
	 * @param objectImg The fixed image that will be displayed by the Renderer to the screen.
	 * @param panelX The fixed X position for the panel to display the image. Render point starts in the top left corner
	 * @param panelY The fixed Y position for the panel to display the image.
	 */
	protected Panel(BufferedImage objectImg, int panelX, int panelY) {
		super(objectImg, panelX, panelY);
	}
}