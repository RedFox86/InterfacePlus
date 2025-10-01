package net.redfox.interfaceplus;

import static java.awt.Color.*;

import net.redfox.interfaceplus.gui.display.Interface;

public class Main {
    static void main() {
        Interface i = new Interface.Builder().title("Hello").color(WHITE).build();
    }
}
