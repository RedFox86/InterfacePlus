package net.redfox.interfaceplus;

import static java.awt.Color.*;

import net.redfox.interfaceplus.gui.display.Interface;

public class Main {
    public static void main(String[] args) {
        Interface i = new Interface.Builder().title("Hello").color(WHITE).build();
    }
}