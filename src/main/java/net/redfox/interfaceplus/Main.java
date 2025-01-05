//package net.redfox.interfaceplus;
//
//import net.redfox.interfaceplus.gui.display.Interface;
//import net.redfox.interfaceplus.gui.display.InterfaceBuilder;
//import net.redfox.interfaceplus.object.util.Panel;
//import net.redfox.interfaceplus.object.util.PanelBuilder;
//import net.redfox.interfaceplus.object.util.animated.AnimatedPanel;
//import net.redfox.interfaceplus.object.util.animated.AnimatedPanelBuilder;
//import net.redfox.interfaceplus.object.util.animated.NodePanel;
//import net.redfox.interfaceplus.object.util.animated.NodePanelBuilder;
//import net.redfox.interfaceplus.object.util.button.Button;
//import net.redfox.interfaceplus.object.util.button.ButtonBuilder;
//import net.redfox.interfaceplus.object.util.text.TextComponent;
//import net.redfox.interfaceplus.object.util.text.TextComponentBuilder;
//
//import static java.awt.Color.*;
//import java.awt.Font;
//
//@SuppressWarnings("unused")
//public class Main {
//	public static void main(String[] args) {
//		Interface i = new InterfaceBuilder().title("Hello").color(WHITE).build();
//		Button b = new ButtonBuilder(i, "/graphics/object/button.png").hoverImg("/graphics/object/button_hover.png").clickImg("/graphics/object/button_press.png").x(100).y(200).build();
//		Panel p = new PanelBuilder(i, "/graphics/object/red_rect.png").x(200).y(150).build();
//		AnimatedPanel a = new AnimatedPanelBuilder(i, new String[]{"/graphics/object/tile0.png", "/graphics/object/tile1.png"}).framerate(50).build();
//		TextComponent t = new TextComponentBuilder(i).setText("egg").x(200).y(500).setText("egg").setColor(RED).setFont(Font.SANS_SERIF).setSize(50).setStyle(Font.BOLD).build();
//		NodePanel n = new NodePanelBuilder(i, new String[]{"/graphics/object/tile0.png", "/graphics/object/tile1.png", "/graphics/object/tile1a.png"}).x(500).y(200).repeat(true).build();
//		i.addTask(new ExampleTask(p));
//		i.addTask(new OtherExampleTask(n));
//		b.onClick(new ExampleTask(b));
//	}
//}