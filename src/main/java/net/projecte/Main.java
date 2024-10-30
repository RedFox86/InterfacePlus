package net.projecte;

import net.projecte.gui.display.Interface;
import net.projecte.gui.display.InterfaceBuilder;
import net.projecte.objects.util.*;
import net.projecte.objects.util.animated.AnimatedPanel;
import net.projecte.objects.util.animated.AnimatedPanelBuilder;
import net.projecte.objects.util.animated.NodePanel;
import net.projecte.objects.util.animated.NodePanelBuilder;
import net.projecte.objects.util.button.Button;
import net.projecte.objects.util.Panel;
import net.projecte.objects.util.button.ButtonBuilder;
import net.projecte.objects.util.text.TextComponent;
import net.projecte.objects.util.text.TextComponentBuilder;

import java.awt.*;

@SuppressWarnings("unused")
public class Main {
	public static void main(String[] args) {
		Interface i = new InterfaceBuilder().title("Hello").color(Color.WHITE).build();
		Button b = new ButtonBuilder(i, "/graphics/object/button.png").hoverImg("/graphics/object/button_hover.png").clickImg("/graphics/object/button_press.png").x(100).y(200).build();
		Panel p = new PanelBuilder(i, "/graphics/object/red_rect.png").x(200).y(150).build();
		AnimatedPanel a = new AnimatedPanelBuilder(i, new String[]{"/graphics/object/tile0.png", "/graphics/object/tile1.png"}).framerate(50).build();
		TextComponent t = new TextComponentBuilder(i).setText("egg").x(200).y(500).setText("egg").setColor(Color.RED).setFont(Font.SANS_SERIF).setSize(50).setStyle(Font.BOLD).build();
		NodePanel n = new NodePanelBuilder(i, new String[]{"/graphics/object/tile0.png", "/graphics/object/tile1.png", "/graphics/object/tile1a.png"}).x(500).y(200).repeat(true).build();
		i.addTask(new ExampleTask(p));
		i.addTask(new OtherExampleTask(n));
		b.onClick(new ExampleTask(b));
	}
}