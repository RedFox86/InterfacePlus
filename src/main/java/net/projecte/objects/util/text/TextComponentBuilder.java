package net.projecte.objects.util.text;

import net.projecte.Logger;
import net.projecte.gui.display.Interface;
import net.projecte.objects.RenderableObjectBuilder;

import java.awt.*;

public class TextComponentBuilder extends RenderableObjectBuilder<TextComponent, TextComponentBuilder> {
	private String displayText = "Untitled";
	private Color displayColor = Color.BLACK;
	private String fontName = "TimesRoman";
	private int displaySize = 10;
	private int displayMode = 0;
	public TextComponentBuilder(Interface i) {
		super(i, null);
	}
	
	@Override
	public TextComponentBuilder x(int objX) {
		return super.setX(objX);
	}
	
	@Override
	public TextComponentBuilder y(int objY) {
		return super.setY(objY);
	}
	public TextComponentBuilder setText(String text) {
		displayText = text;
		return this;
	}
	public TextComponentBuilder setColor(Color color) {
		displayColor = color;
		return this;
	}
	public TextComponentBuilder setFont(String name) {
		fontName = name;
		return this;
	}
	public TextComponentBuilder setSize(int size) {
		displaySize = size;
		return this;
	}
	public TextComponentBuilder setStyle(int mode) {
		displayMode = mode;
		return this;
	}
	
	@Override
	public TextComponent build() {
		Logger.log("Text Component successfully built.");
		return super.build(new TextComponent(displayText, x, y, displayColor, fontName, displaySize, displayMode));
	}
}