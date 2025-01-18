package net.redfox.interfaceplus.object;

import net.redfox.interfaceplus.gui.util.WindowContext;

import java.awt.image.BufferedImage;

@SuppressWarnings("unused")
public class RenderableObject {
	protected BufferedImage displayImage;
	private double x;
	private double y;
	private final int width;
	private final int height;
	protected RenderableObject(BufferedImage displayImage, double x, double y) {
		this.x = x;
		this.y = y;
		this.displayImage = displayImage;
		this.width = displayImage.getWidth();
		this.height = displayImage.getHeight();
	}
	protected RenderableObject(int width, int height, double x, double y) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}
	private void drawImage(WindowContext context) {
		context.getGraphics2D().drawImage(displayImage, (int)(x+0.5), (int)(y+0.5), width, height, null);
	}
	public void setX(double x) {
		this.x = x;
	}
	public void setY(double y) {
		this.y = y;
	}
	public double getX() {
		return x;
	}
	public double getY() {
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