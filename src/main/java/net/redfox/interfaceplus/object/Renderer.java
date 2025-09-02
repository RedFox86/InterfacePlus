package net.redfox.interfaceplus.object;

import java.util.ArrayList;

import net.redfox.interfaceplus.exception.RendererNotFoundException;
import net.redfox.interfaceplus.gui.util.WindowContext;

public class Renderer {
    private final ArrayList<Renderable> objects;
    private final ArrayList<Renderable> renderableObjectQueue;
    private final int identifier;
    private static final ArrayList<Renderer> renderers = new ArrayList<>();

    public Renderer(int identifier) {
        objects = new ArrayList<>();
        renderableObjectQueue = new ArrayList<>();
        this.identifier = identifier;
        renderers.add(this);
    }

    public void renderObjects(WindowContext context) {
        if (!renderableObjectQueue.isEmpty()) {
            objects.addAll(renderableObjectQueue);
            renderableObjectQueue.clear();
        }

        for (Renderable r : objects) {
            r.render(context);
        }
    }

    /**
     * Registers a new RenderableObject with this Renderer so that it is displayed on screen.
     *
     * @param object The RenderableObject to be displayed.
     */
    public void register(Renderable object) {
        renderableObjectQueue.add(object);
    }

    public static Renderer getRenderer(int identifier) throws RendererNotFoundException {
        for (Renderer r : renderers) {
            if (r.identifier == identifier) {
                return r;
            }
        }
        throw new RendererNotFoundException("Renderer with identifier " + identifier + " not found!");
    }
}
