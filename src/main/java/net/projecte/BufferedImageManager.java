package net.projecte;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class BufferedImageManager {
	static BufferedImage img = null;
	public static BufferedImage getImage(String imgPath) {
		try {
			img = ImageIO.read(BufferedImageManager.class.getResourceAsStream(imgPath));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return img;
	}
}