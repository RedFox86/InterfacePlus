package net.projecte;

import net.projecte.gui.display.Interface;
import net.projecte.gui.display.InterfaceBuilder;
import net.projecte.objects.util.Button;
import net.projecte.objects.util.ButtonBuilder;
import net.projecte.objects.util.Panel;
import net.projecte.objects.util.PanelBuilder;

import java.awt.*;

@SuppressWarnings("unused")
public class Main {
	public static void main(String[] args) {
		Interface i = new InterfaceBuilder().title("Hello").color(Color.BLACK).build();
		Button b = new ButtonBuilder(i, "/graphics/object/button.png").hoverImg("/graphics/object/button_hover.png").clickImg("/graphics/object/button_press.png").x(100).y(200).build();
		Panel p = new PanelBuilder(i, "/graphics/object/red_rect.png").x(200).y(150).build();
		i.addTask(new ExampleTask(p));
		b.onClick(new ExampleTask(b));
	}
}