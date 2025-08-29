package net.redfox.interfaceplus.object.pointer;

import net.redfox.interfaceplus.object.Renderable;
import net.redfox.interfaceplus.object.TaskType;

public class LastPointer implements Renderable {
    private final int offsetX;
    private final int offsetY;

    public LastPointer(int offsetX, int offsetY) {
        this.offsetX = offsetX;
        this.offsetY = offsetY;
    }

    public int getOffsetX() {
        return offsetX;
    }

    public int getOffsetY() {
        return offsetY;
    }

    @Override
    public TaskType getType() {
        return TaskType.LAST;
    }
}
