package net.redfox.interfaceplus;

import static java.awt.Color.*;

import net.redfox.interfaceplus.gui.display.Interface;
import net.redfox.interfaceplus.math.Vector2;
import net.redfox.interfaceplus.object.util.button.Button;
import net.redfox.interfaceplus.util.BufferedImageManager;

@SuppressWarnings("unused")
public class Main {
    public static void main(String[] args) {
        Interface i = new Interface.Builder().title("Hello").color(WHITE).build();

        Button b = new Button.Builder(i.getRenderer())
            .position(new Vector2(100, 100))
            .hoverImage(BufferedImageManager.getImage("/graphics/object/button_hover.png"))
            .defaultImage(BufferedImageManager.getImage("/graphics/object/button.png"))
            .clickImage(BufferedImageManager.getImage("/graphics/object/button_press.png"))
            .build();
    }
}