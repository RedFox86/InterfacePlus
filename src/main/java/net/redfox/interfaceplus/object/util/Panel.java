package net.redfox.interfaceplus.object.util;

import java.awt.image.BufferedImage;
import net.redfox.interfaceplus.object.standard.RenderableObject;

public class Panel extends RenderableObject {
    protected Panel(BufferedImage displayImage, int x, int y) {
        super(displayImage, x, y);
    }

    @Override
    public String getName() {
        return "Panel";
    }
}
