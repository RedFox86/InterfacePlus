package net.redfox.interfaceplus.object.util.text;

import net.redfox.interfaceplus.gui.util.WindowContext;
import net.redfox.interfaceplus.object.RenderableObject;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;


@SuppressWarnings("unused")
public class TextComponent extends RenderableObject {
	private Font font;
	private Color color;
	private String contents;
	protected TextComponent(String contents, int width, int height, int x, int y, Color color, String font, int fontSize, int style) {
		super(width, height, x, y);
		this.contents = contents;
		this.color = color;
		this.font = new Font(font, style, fontSize);
	}
	public void setText(String text) {
		contents = text;
	}
	public void setFont(String name) {
		font = new Font(name, font.getStyle(), font.getSize());
	}
	public void setSize(int size) {
		font = new Font(font.getName(), font.getStyle(), size);
	}
	public void setColor(Color color) {
		this.color = color;
	}
	@Override
	public void update(WindowContext context) {
		Graphics2D g = context.getGraphics2D();
		g.setFont(font);
		g.setColor(color);
		g.drawString(contents, this.getX(), this.getY());
	}
}