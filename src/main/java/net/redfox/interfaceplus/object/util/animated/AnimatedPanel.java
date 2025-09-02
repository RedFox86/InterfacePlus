package net.redfox.interfaceplus.object.util.animated;

import java.awt.image.BufferedImage;
import net.redfox.interfaceplus.gui.util.WindowContext;
import net.redfox.interfaceplus.math.Vector2;
import net.redfox.interfaceplus.object.RenderableImage;
import net.redfox.interfaceplus.object.Renderer;
import net.redfox.interfaceplus.object.util.Panel;

public class AnimatedPanel extends Panel {
    private final BufferedImage[] displayImages;
    private final int maxFrame;
    private final int frameRate;
    private int currentFrame;
    private int frameDelay;

    protected AnimatedPanel(BufferedImage[] displayImages, Vector2 position, int frameRate) {
        super(displayImages[0], position);
        this.displayImages = displayImages;
        maxFrame = this.displayImages.length;
        this.frameRate = frameRate;
    }

    @Override
    public void update(WindowContext context) {
        if (frameDelay == frameRate) {
            frameDelay = 0;
            if (currentFrame == maxFrame - 1) {
                currentFrame = 0;
            } else {
                currentFrame++;
            }
            displayImage = displayImages[currentFrame];
        } else {
            frameDelay++;
        }
        super.update(context);
    }

    @Override
    public String getName() {
        return "AnimatedPanel";
    }

    public static class Builder extends Panel.Builder {
        private BufferedImage[] displayImages;
        private int maxFrame;
        private int frameRate;
        private int currentFrame;
        private int frameDelay;
        public Builder(Renderer renderer) {
            super(renderer);
        }

        @Override
        public AnimatedPanel.Builder position(Vector2 position) {
            super.setPosition(position);
            return this;
        }

        @Override
        public AnimatedPanel.Builder displayImage(BufferedImage displayImage) {
            super.setDisplayImage(displayImage);
            return this;
        }

        @Override
        public AnimatedPanel build() {
            return super.build(new AnimatedPanel(displayImage, position));
        }
    }
}
