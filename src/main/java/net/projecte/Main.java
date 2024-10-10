package net.projecte;

import net.projecte.gui.Interface;
import net.projecte.gui.InterfaceBuilder;
import net.projecte.objects.RenderableObject;
import net.projecte.objects.RenderableObjectBuilder;

import java.awt.*;

public class Main {
	public static void main(String[] args) {
		Interface i = new InterfaceBuilder().title("Hello").color(Color.BLACK).build();
		RenderableObject r = new RenderableObjectBuilder(i, "/graphics/object/red_rect.png").x(100).y(100).build();
		i.addTask(new ExampleTask(r));
	}
}