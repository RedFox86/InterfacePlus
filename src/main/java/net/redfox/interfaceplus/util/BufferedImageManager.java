package net.redfox.interfaceplus.util;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import javax.imageio.ImageIO;

public class BufferedImageManager {
    private static final Logger LOGGER = new Logger(BufferedImageManager.class.getName());

    public static BufferedImage getImage(String imgPath) {
        try {
            InputStream stream = BufferedImageManager.class.getResourceAsStream(imgPath);
            if (stream == null) {
                LOGGER.warn("An image at '" + imgPath + "' was not found! Some renderable objects may appear invisible!");
            } else {
                LOGGER.info("Image at '" + imgPath + "' was successfully loaded!");
                return ImageIO.read(stream);
            }
        } catch (IOException _) {}
        return new BufferedImage(1, 1, 1);
    }
}
