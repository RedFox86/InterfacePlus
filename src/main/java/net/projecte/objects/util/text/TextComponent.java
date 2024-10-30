package net.projecte.objects.util.text;

import net.projecte.gui.util.WindowContext;
import net.projecte.objects.RenderableObject;

import java.awt.*;

@SuppressWarnings("unused")
public class TextComponent extends RenderableObject {
	private Font displayFont;
	private Color displayColor;
	private String displayText;
	protected TextComponent(String textComponentDisplayText, int IX, int IY, Color textComponentColor, String textComponentFontName, int textComponentFontSize, int textComponentStyle) {
		super(null, IX, IY);
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