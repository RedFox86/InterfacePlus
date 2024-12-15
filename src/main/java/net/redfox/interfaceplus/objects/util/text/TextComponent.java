package net.redfox.interfaceplus.objects.util.text;

import net.redfox.interfaceplus.gui.util.WindowContext;
import net.redfox.interfaceplus.objects.RenderableObject;

import java.awt.*;

@SuppressWarnings("unused")
public class TextComponent extends RenderableObject {
	private Font displayFont;
	private Color displayColor;
	private String displayText;
	protected TextComponent(String textComponentDisplayText, int textComponentWidth, int textComponentHeight, int IX, int IY, Color textComponentColor, String textComponentFontName, int textComponentFontSize, int textComponentStyle) {
		super(textComponentWidth, textComponentHeight, IX, IY);
		displayText = textComponentDisplayText;
		displayColor = textComponentColor;
		displayFont = new Font(textComponentFontName, textComponentStyle, textComponentFontSize);
	}
	public void setText(String text) {
		displayText = text;
	}
	public void setFont(String name) {
		displayFont = new Font(name, displayFont.getStyle(), displayFont.getSize());
	}
	public void setSize(int size) {
		displayFont = new Font(displayFont.getName(), displayFont.getStyle(), size);
	}
	public void setColor(Color color) {
		displayColor = color;
	}
	@Override
	public void update(WindowContext context) {
		context.getGraphics2D().setFont(displayFont);
		context.getGraphics2D().setColor(displayColor);
		context.getGraphics2D().drawString(displayText, this.getX(), this.getY());
	}
}