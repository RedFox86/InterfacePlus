package net.redfox.interfaceplus.util;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import javax.imageio.ImageIO;

public class BufferedImageManager {
    public static BufferedImage getImage(String imgPath) {
        try {
            InputStream stream = BufferedImageManager.class.getResourceAsStream(imgPath);
            if (stream == null) {
                Logger.warn("Image not found at path " + imgPath);
            } else {
                Logger.log("Image " + imgPath + " successfully loaded.");
                return ImageIO.read(stream);
            }
        } catch (IOException e) {
            Logger.error("Failed to load an image because it likely didn't exist: " + imgPath);
        }
        return null;
    }
}
