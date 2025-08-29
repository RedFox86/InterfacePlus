package net.redfox.interfaceplus.object.util.animated;

import java.awt.image.BufferedImage;
import net.redfox.interfaceplus.object.standard.RenderableObjectBuilder;
import net.redfox.interfaceplus.util.BufferedImageManager;
import net.redfox.interfaceplus.util.Logger;

public class NodePanelBuilder extends RenderableObjectBuilder<NodePanel, NodePanelBuilder> {
    private final BufferedImage[] displayImages;
    private boolean repeat;

    /**
     * @param identifier The identifier of the renderer that this RenderableObject will use to be
     *     displayed.
     * @param displayImages An array of images that will be loaded and displayed on the screen.
     */
    public NodePanelBuilder(int identifier, String[] displayImages) {
        super(identifier, displayImages[0]);
        this.displayImages = new BufferedImage[displayImages.length];
        for (int j = 0; j < displayImages.length; j++) {
            this.displayImages[j] = BufferedImageManager.getImage(displayImages[j]);
        }
        repeat = true;
    }

    public NodePanelBuilder repeat(boolean repeat) {
        this.repeat = repeat;
        return this;
    }

    @Override
    public NodePanelBuilder x(int objX) {
        return super.setX(objX);
    }

    @Override
    public NodePanelBuilder y(int objY) {
        return super.setY(objY);
    }

    @Override
    public NodePanel build() {
        Logger.log("Node Panel successfully built.");
        return super.build(new NodePanel(displayImages, x, y, repeat));
    }
}
