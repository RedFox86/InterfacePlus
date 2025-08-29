package net.redfox.interfaceplus.object.util.button;

import java.awt.image.BufferedImage;
import net.redfox.interfaceplus.object.standard.RenderableObjectBuilder;
import net.redfox.interfaceplus.util.BufferedImageManager;
import net.redfox.interfaceplus.util.Logger;

@SuppressWarnings("unused")
public class ButtonBuilder extends RenderableObjectBuilder<Button, ButtonBuilder> {
    private final BufferedImage[] displayImages;
    private boolean holdTrigger;

    /**
     * @param identifier The identifier of the renderer that this RenderableObject will use to be
     *     displayed.
     * @param imagePath The path for the image that will be loaded and displayed on the screen.
     */
    public ButtonBuilder(int identifier, String imagePath) {
        super(identifier, imagePath);
        displayImages = new BufferedImage[] {displayImage, displayImage, displayImage};
        holdTrigger = false;
    }

    @Override
    public ButtonBuilder x(int x) {
        return super.setX(x);
    }

    @Override
    public ButtonBuilder y(int y) {
        return super.setY(y);
    }

    public ButtonBuilder hoverImg(String imgPath) {
        displayImages[1] = BufferedImageManager.getImage(imgPath);
        return this;
    }

    public ButtonBuilder clickImg(String imgPath) {
        displayImages[2] = BufferedImageManager.getImage(imgPath);
        return this;
    }

    public ButtonBuilder hold() {
        holdTrigger = true;
        return this;
    }

    @Override
    public Button build() {
        Logger.log("Button successfully built.");
        return super.build(new Button(displayImages, x, y, holdTrigger));
    }
}
