package net.redfox.interfaceplus;

import static java.awt.Color.*;

import net.redfox.interfaceplus.gui.display.Interface;
import net.redfox.interfaceplus.object.util.Panel;
import net.redfox.interfaceplus.util.BufferedImageManager;

@SuppressWarnings("unused")
public class Main {
    public static void main(String[] args) {
        Interface i = new Interface.Builder().title("Hello").color(WHITE).build();

        Panel p = new Panel.Builder(i.getRenderer()).displayImage(BufferedImageManager.getImage("/graphics/object/red_rect.png")).build();
    }
}
