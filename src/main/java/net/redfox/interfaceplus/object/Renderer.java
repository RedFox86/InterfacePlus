package net.redfox.interfaceplus.object;

import java.util.ArrayList;
import java.util.logging.Logger;

import net.redfox.interfaceplus.gui.util.WindowContext;

public class Renderer {
    private final ArrayList<Renderable> objects;
    private final ArrayList<Renderable> renderableObjectQueue;
    private final Logger logger;

    public Renderer() {
        objects = new ArrayList<>();
        renderableObjectQueue = new ArrayList<>();
        logger = Logger.getLogger("Renderer");
    }

    public Logger getLogger() {
        return logger;
    }

    public void renderObjects(WindowContext context) {
        if (!renderableObjectQueue.isEmpty()) updateRenderableObjectList();

        for (Renderable r : objects) {
            r.render(context);
        }
    }

    private void updateRenderableObjectList() {
        objects.addAll(renderableObjectQueue);
        renderableObjectQueue.clear();
    }

    public void register(Renderable object) {
        renderableObjectQueue.add(object);
    }
}
