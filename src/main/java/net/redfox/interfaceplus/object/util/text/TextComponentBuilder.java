package net.redfox.interfaceplus.object.util.text;

import net.redfox.interfaceplus.util.Logger;
import net.redfox.interfaceplus.gui.display.Interface;
import net.redfox.interfaceplus.object.RenderableObjectBuilder;

import java.awt.Color;

public class TextComponentBuilder extends RenderableObjectBuilder<TextComponent, TextComponentBuilder> {
	private String contents;
	private Color color;
	private String font;
	private int size;
	private int mode;
	/**
	 * @param bInterface The interface that the TextComponent will be displayed on - used to add to the objects list in Renderer.
	 */
	public TextComponentBuilder(Interface bInterface) {
		super(bInterface, null);
		mode = 0;
		size = 10;
		font = "TimesRoman";
		color = Color.BLACK;
		contents = "Untitled";
	}
	
	@Override
	public TextComponentBuilder x(int x) {
		return super.setX(x);
	}
	
	@Override
	public TextComponentBuilder y(int y) {
		return super.setY(y);
	}
	public TextComponentBuilder setText(String text) {
		contents = text;
		return this;
	}
	public TextComponentBuilder setColor(Color color) {
		this.color = color;
		return this;
	}
	public TextComponentBuilder setFont(String name) {
		font = name;
		return this;
	}
	public TextComponentBuilder setSize(int size) {
		this.size = size;
		return this;
	}
	public TextComponentBuilder setStyle(int mode) {
		this.mode = mode;
		return this;
	}
	
	@Override
	public TextComponent build() {
		Logger.log("Text Component successfully built.");
		return super.build(new TextComponent(contents, 100, contents.length()*20, x, y, color, font, size, mode));
	}
}