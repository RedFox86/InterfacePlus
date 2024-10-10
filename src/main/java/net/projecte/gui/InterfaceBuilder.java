package net.projecte.gui;

import net.projecte.Task;
import net.projecte.objects.Renderer;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class InterfaceBuilder {
	private String title;
	private Dimension size;
	private Color background;
	private int FPS;
	public InterfaceBuilder() {
		title = "Untitled";
		size = new Dimension(1920, 1080);
		background = Color.WHITE;
		FPS = 60;
	}
	public InterfaceBuilder title(String bTitle) {
		title = bTitle;
		return this;
	}
	public InterfaceBuilder color(Color bColor) {
		background = bColor;
		return this;
	}
	public InterfaceBuilder size(Dimension bDimension) {
		size = bDimension;
		return this;
	}
	public InterfaceBuilder FPS(int bFPS) {
		FPS = bFPS;
		return this;
	}
	public Interface build() {
		return new Interface(title, size, background, FPS);
	}
}