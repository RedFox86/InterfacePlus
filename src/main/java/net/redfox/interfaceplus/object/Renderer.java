package net.redfox.interfaceplus.object;

import java.util.ArrayList;

import net.redfox.interfaceplus.exception.PointerPointsToNothingException;
import net.redfox.interfaceplus.gui.util.WindowContext;
import net.redfox.interfaceplus.object.standard.RenderableObject;
import net.redfox.interfaceplus.util.Logger;

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

        for (int i = 0; i < objects.size(); i++) {
            switch (objects.get(i).getType()) {
                case RUN -> ((RenderableObject)objects.get(i)).update(context);
                case LAST -> {
                    try {
                        getLastRenderableObject(i).update(context);
                    } catch (PointerPointsToNothingException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    private RenderableObject getLastRenderableObject(int startingIndex) throws PointerPointsToNothingException {
        for (int i = startingIndex - 1; i > 0; i--) {
            if (objects.get(i) instanceof RenderableObject r) {
                return r;
            }
        }
        throw new PointerPointsToNothingException("Pointer pointed backwards to nothing at starting index " + startingIndex);
    }

    /**
     * Registers a new RenderableObject with this Renderer so that it is displayed on screen.
     *
     * @param object The RenderableObject to be displayed.
     */
    public void register(Renderable object) {
        renderableObjectQueue.add(object);
    }

    public static Renderer getRenderer(int identifier) {
        for (Renderer r : renderers) {
            if (r.identifier == identifier) {
                return r;
            }
        }
        Logger.error("Renderer with id " + identifier + " was searched for, but not found!");
        return null;
    }
}
