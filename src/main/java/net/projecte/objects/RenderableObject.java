package net.projecte.objects;

import net.projecte.gui.util.WindowContext;

import java.awt.image.BufferedImage;

@SuppressWarnings("unused")
public class RenderableObject {
	protected BufferedImage displayImg;
	private int x;
	private int y;
	private final int sizeX;
	private final int sizeY;
	protected RenderableObject(BufferedImage objectImg, int IX, int IY) {
		x = IX;
		y = IY;
		displayImg = objectImg;
		if (objectImg != null) {
			sizeX = displayImg.getWidth();
			sizeY = displayImg.getHeight();
		} else {
			sizeX = 0;
			sizeY = 0;
		}
	}
	private void drawImage(WindowContext context) {
		if (displayImg == null) {
			return;
		}
		context.getGraphics2D().drawImage(displayImg, x, y, sizeX, sizeY, null);
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
	public int getSizeX() {
		return sizeX;
	}
	public int getSizeY() {
		return sizeY;
	}
	public void update(WindowContext context) {
		drawImage(context);
	}
}