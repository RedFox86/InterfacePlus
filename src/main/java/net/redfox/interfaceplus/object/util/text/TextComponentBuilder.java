package net.redfox.interfaceplus.object.util.text;

import java.awt.Color;
import net.redfox.interfaceplus.object.standard.RenderableObjectBuilder;
import net.redfox.interfaceplus.util.Logger;

public class TextComponentBuilder
        extends RenderableObjectBuilder<TextComponent, TextComponentBuilder> {
    private String contents;
    private Color color;
    private String font;
    private int size;
    private int mode;

    /**
     * @param identifier The identifier of the renderer that this RenderableObject will use to be
     *     displayed.
     */
    public TextComponentBuilder(int identifier) {
        super(identifier, null);
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
        return super.build(
                new TextComponent(
                        contents, 100, contents.length() * 20, x, y, color, font, size, mode));
    }
}
