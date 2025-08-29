package net.redfox.interfaceplus.object.standard;

import java.awt.image.BufferedImage;
import net.redfox.interfaceplus.gui.util.WindowContext;
import net.redfox.interfaceplus.object.Renderable;
import net.redfox.interfaceplus.object.TaskType;

public abstract class RenderableObject implements Renderable {
    private static int totalRenderableObjects = 0;
    protected BufferedImage displayImage;
    private double x;
    private double y;
    private final int width;
    private final int height;
    private final int objectID;

    protected RenderableObject(BufferedImage displayImage, double x, double y) {
        this(displayImage.getWidth(), displayImage.getHeight(), x, y);
        this.displayImage = displayImage;
    }

    protected RenderableObject(int width, int height, double x, double y) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        totalRenderableObjects++;
        objectID = totalRenderableObjects;
    }

    private void drawImage(WindowContext context) {
        context.getGraphics2D()
                .drawImage(displayImage, (int) (x + 0.5), (int) (y + 0.5), width, height, null);
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public void update(WindowContext context) {
        drawImage(context);
    }

    public abstract String getName();

    @Override
    public TaskType getType() {
        return TaskType.RUN;
    }

    @Override
    public String toString() {
        return getName() + objectID;
    }
}
