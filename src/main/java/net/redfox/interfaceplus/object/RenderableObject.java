package net.redfox.interfaceplus.object;

import net.redfox.interfaceplus.gui.util.WindowContext;

import java.awt.image.BufferedImage;

@SuppressWarnings("unused")
public class RenderableObject {
	protected BufferedImage displayImage;
	private int x;
	private int y;
	private final int width;
	private final int height;
	protected RenderableObject(BufferedImage renderableObjectImage, int renderableObjectX, int renderableObjectY) {
		x = renderableObjectX;
		y = renderableObjectY;
		displayImage = renderableObjectImage;
		width = displayImage.getWidth();
		height = displayImage.getHeight();
	}
	protected RenderableObject(int renderableObjectWidth, int renderableObjectHeight, int renderableObjectX, int renderableObjectY) {
		x = renderableObjectX;
		y = renderableObjectY;
		width = renderableObjectWidth;
		height = renderableObjectHeight;
	}
	private void drawImage(WindowContext context) {
		context.getGraphics2D().drawImage(displayImage, x, y, width, height, null);
	}
	public void setX(int IX) {
		x = IX;
	}
	public void setY(int IY) {
		y = IY;
	}
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	public int getWidth() {
		return width;
	}
	public int getHeight() {
		return height;
	}
	public void update(WindowContext context) {
		drawImage(context);
	}
}