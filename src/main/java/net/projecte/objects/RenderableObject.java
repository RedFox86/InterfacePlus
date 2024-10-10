package net.projecte.objects;

import net.projecte.BufferedImageManager;
import net.projecte.gui.Interface;

import java.awt.*;
import java.awt.image.BufferedImage;

public class RenderableObject {
	private final BufferedImage img;
	private int x;
	private int y;
	private final int sizeX;
	private final int sizeY;
	public RenderableObject(BufferedImage objectImg, int IX, int IY) {
		x = IX;
		y = IY;
		img = objectImg;
		sizeX = img.getWidth();
		sizeY = img.getHeight();
	}
	public void drawImage(Graphics2D g2) {
		g2.drawImage(img, x, y, sizeX, sizeY, null);
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
}