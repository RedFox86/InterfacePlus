package net.redfox.interfaceplus.object;

import java.awt.image.BufferedImage;
import net.redfox.interfaceplus.gui.util.WindowContext;
import net.redfox.interfaceplus.math.Size2;
import net.redfox.interfaceplus.math.Vector2;

public abstract class RenderableImage implements Renderable {
    protected BufferedImage displayImage;
    private Vector2 position;
    private Size2 size;

    protected RenderableImage(BufferedImage displayImage, Vector2 position) {
        this(position, new Size2(displayImage.getWidth(), displayImage.getHeight()));
        this.displayImage = displayImage;
    }

    protected RenderableImage(Vector2 position, Size2 size) {
        this.position = position;
        this.size = size;
    }

    private void drawImage(WindowContext context) {
        context.getGraphics2D()
                .drawImage(displayImage, (int) (position.getX() + 0.5), (int) (position.getY() + 0.5), size.getWidth(), size.getHeight(), null);
    }

    public void setX(double x) {
        this.position.setX(x);
    }

    public void setY(double y) {
        this.setY(y);
    }

    public void setPosition(Vector2 position) {
        this.position = position;
    }

    public void setPosition(double x, double y) {
        position.setX(x);
        position.setY(y);
    }

    public double getX() {
        return position.getX();
    }

    public double getY() {
        return position.getY();
    }

    public Vector2 getPosition() {
        return position;
    }

    public int getWidth() {
        return size.getWidth();
    }

    public int getHeight() {
        return size.getHeight();
    }

    public void update(WindowContext context) {
        drawImage(context);
    }

    public abstract String getName();

    @Override
    public void render(WindowContext context) {
        update(context);
    }

    @Override
    public String toString() {
        return getName() + this.hashCode();
    }

    protected abstract static class Builder {
        protected BufferedImage displayImage;
        protected Vector2 position;
        private final Renderer renderer;

        public Builder(Renderer renderer) {
            this.renderer = renderer;
            displayImage = null;
            position = new Vector2(0, 0);
        }

        protected final void setPosition(Vector2 position) {
            this.position.setX(position.getX());
            this.position.setY(position.getY());
        }

        protected final void setDisplayImage(BufferedImage displayImage) {
            this.displayImage = displayImage;
        }

        public <T extends Renderable> T build(T object) {
            renderer.register(object);
            return object;
        }

        public abstract <T extends Renderable> T build();
        public abstract <K extends RenderableImage.Builder> K position(Vector2 position);
        public abstract <K extends RenderableImage.Builder> K displayImage(BufferedImage displayImage);
    }
}
