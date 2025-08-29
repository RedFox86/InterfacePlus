package net.redfox.interfaceplus.object.standard;

import java.awt.image.BufferedImage;
import net.redfox.interfaceplus.object.Renderer;
import net.redfox.interfaceplus.util.BufferedImageManager;
import net.redfox.interfaceplus.util.Logger;

@SuppressWarnings("unchecked")
public abstract class RenderableObjectBuilder<
        K extends RenderableObject, T extends RenderableObjectBuilder<K, T>> {
    protected final BufferedImage displayImage;
    protected int x;
    protected int y;
    protected final int identifier;

    /**
     * @param identifier The identifier of the renderer that this RenderableObject will use to be
     *     displayed.
     * @param imagePath The path for the image that will be loaded and displayed on the screen.
     */
    protected RenderableObjectBuilder(int identifier, String imagePath) {
        this.x = 0;
        this.y = 0;
        this.identifier = identifier;
        if (imagePath != null) {
            displayImage = BufferedImageManager.getImage(imagePath);
        } else {
            displayImage = null;
        }
    }

    public abstract T x(int objX);

    public abstract T y(int objY);

    public abstract K build();

    /**
     * Use this when overriding the x() method in your subclass.
     *
     * @param x The x value of this RenderableObject.
     * @return A RenderableObjectBuilder with the new x value.
     */
    protected T setX(int x) {
        this.x = x;
        return (T) this;
    }

    /**
     * Use this when overriding the y() method in your subclass.
     *
     * @param y The x value of this RenderableObject.
     * @return A RenderableObjectBuilder with the new y value.
     */
    protected T setY(int y) {
        this.y = y;
        return (T) this;
    }

    /**
     * Use this when overriding the build() method in your subclass.
     *
     * @param object The object that you are building with this Builder
     * @return The new object that you built, now registered with the appropriate Renderer
     */
    protected K build(K object) {
        Renderer r = Renderer.getRenderer(identifier);
        if (r != null) {
            r.register(object);
        } else {
            Logger.error(
                    "Failed to build object because the returned Renderer was null! OBJ-"
                            + object
                            + "-"
                            + identifier);
        }
        return object;
    }
}
