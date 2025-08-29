package net.redfox.interfaceplus.object.util;

import net.redfox.interfaceplus.object.standard.RenderableObjectBuilder;
import net.redfox.interfaceplus.util.Logger;

public class PanelBuilder extends RenderableObjectBuilder<Panel, PanelBuilder> {
    /**
     * @param imagePath The path for the image that will be loaded and displayed on the screen.
     * @param identifier The identifier of the renderer that this RenderableObject will use to be
     *     displayed.
     */
    public PanelBuilder(int identifier, String imagePath) {
        super(identifier, imagePath);
    }

    @Override
    public PanelBuilder x(int x) {
        return super.setX(x);
    }

    @Override
    public PanelBuilder y(int y) {
        return super.setY(y);
    }

    @Override
    public Panel build() {
        Logger.log("Panel successfully built.");
        return super.build(new Panel(displayImage, x, y));
    }
}
