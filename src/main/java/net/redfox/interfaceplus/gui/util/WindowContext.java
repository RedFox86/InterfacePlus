package net.redfox.interfaceplus.gui.util;

import java.awt.*;

public class WindowContext {
	private Graphics2D g2;
	private Point location;
	public WindowContext(Graphics2D windowContextGraphics2D, Point windowContextLocation) {
		g2 = windowContextGraphics2D;
		location = windowContextLocation;
	}
	public Graphics2D getGraphics2D() {
		return g2;
	}
	public Point getLocation() {
		return location;
	}
	public void setG2(Graphics2D windowContextGraphics2D) {
		g2 = windowContextGraphics2D;
	}
	public void setLocation(Point windowContextLocation) {
		location = windowContextLocation;
	}
}