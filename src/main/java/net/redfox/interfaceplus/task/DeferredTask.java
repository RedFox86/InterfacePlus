package net.redfox.interfaceplus.task;

import net.redfox.interfaceplus.object.RenderableObject;

@SuppressWarnings("unused")
public abstract class DeferredTask<T extends RenderableObject> implements Task {
	protected T container;
	public abstract void fill(T container);
}