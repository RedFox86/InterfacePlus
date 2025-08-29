package net.redfox.interfaceplus.object.util.animated;

import java.awt.image.BufferedImage;
import net.redfox.interfaceplus.object.standard.RenderableObjectBuilder;
import net.redfox.interfaceplus.util.BufferedImageManager;
import net.redfox.interfaceplus.util.Logger;

public class AnimatedPanelBuilder
        extends RenderableObjectBuilder<AnimatedPanel, AnimatedPanelBuilder> {
    private final BufferedImage[] displayImages;
    private int frameRate;

    /**
     * @param identifier The identifier of the renderer that this RenderableObject will use to be
     *     displayed.
     * @param displayImages The array of images that will be loaded and displayed on the screen.
     */
    public AnimatedPanelBuilder(int identifier, String[] displayImages) {
        super(identifier, displayImages[0]);
        this.displayImages = new BufferedImage[displayImages.length];
        for (int i = 0; i < displayImages.length; i++) {
            this.displayImages[i] = BufferedImageManager.getImage(displayImages[i]);
        }
        frameRate = 10;
    }

    public AnimatedPanelBuilder frameRate(int frameRate) {
        this.frameRate = frameRate;
        return this;
    }

    @Override
    public AnimatedPanelBuilder x(int x) {
        return super.setX(x);
    }

    @Override
    public AnimatedPanelBuilder y(int y) {
        return super.setY(y);
    }

    @Override
    public AnimatedPanel build() {
        Logger.log("Animated Panel successfully built.");
        return super.build(new AnimatedPanel(displayImages, x, y, frameRate));
    }
}
