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
	protected RenderableObject(BufferedImage displayImage, int x, int y) {
		this.x = x;
		this.y = y;
		this.displayImage = displayImage;
		this.width = displayImage.getWidth();
		this.height = displayImage.getHeight();
	}
	protected RenderableObject(int width, int height, int x, int y) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}
	private void drawImage(WindowContext context) {
		context.getGraphics2D().drawImage(displayImage, x, y, width, height, null);
	}
	public void setX(int x) {
		this.x = x;
	}
	public void setY(int y) {
		this.y = y;
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