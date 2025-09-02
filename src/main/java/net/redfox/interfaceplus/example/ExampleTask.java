package net.redfox.interfaceplus.example;

import net.redfox.interfaceplus.object.RenderableImage;
import net.redfox.interfaceplus.task.Task;

public class ExampleTask implements Task {
    private final RenderableImage object;

    public ExampleTask(RenderableImage r) {
        object = r;
    }

    @Override
    public void execute() {
        object.setX(object.getX() + 1);
    }
}
