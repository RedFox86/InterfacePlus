package net.projecte.gui.util;

import net.projecte.objects.RenderableObject;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MouseHandler implements MouseListener {
	public static boolean mouseDown = false;
	@Override
	public void mouseClicked(MouseEvent e) {

	}

	@Override
	public void mousePressed(MouseEvent e) {
		mouseDown = true;
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		mouseDown = false;
	}

	@Override
	public void mouseEntered(MouseEvent e) {

	}

	@Override
	public void mouseExited(MouseEvent e) {

	}
	public static Point getMouseLocation() {
		return MouseInfo.getPointerInfo().getLocation();
	}
	public static boolean overlaps(RenderableObject object, WindowContext context) {
		Point mouseLocation = getMouseLocation();
		Point windowLocation = context.getLocation();
		mouseLocation.x-=windowLocation.x;
		mouseLocation.y-=windowLocation.y;
		return object.getX() <= mouseLocation.x && object.getX() + object.getSizeX() >= mouseLocation.x && object.getY() <= mouseLocation.y && object.getY() + object.getSizeY() >= mouseLocation.y;
	}
}