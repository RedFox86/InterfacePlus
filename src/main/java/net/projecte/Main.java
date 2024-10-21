package net.projecte;

import net.projecte.gui.Interface;
import net.projecte.gui.InterfaceBuilder;
import net.projecte.objects.util.Button;
import net.projecte.objects.util.ButtonBuilder;
import net.projecte.objects.util.Panel;
import net.projecte.objects.util.PanelBuilder;

import java.awt.*;

public class Main {
	public static void main(String[] args) {
		Interface i = new InterfaceBuilder().title("Hello").color(Color.BLACK).build();
		Button b = new ButtonBuilder(i, "/graphics/object/red_rect.png").x(100).y(200).build();
		Panel p = new PanelBuilder(i, "/graphics/object/red_rect.png").x(200).y(150).build();
		i.addTask(new ExampleTask(b));
	}
}