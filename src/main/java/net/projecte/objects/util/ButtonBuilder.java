package net.projecte.objects.util;

import net.projecte.BufferedImageManager;
import net.projecte.Task;
import net.projecte.gui.display.Interface;
import net.projecte.objects.RenderableObjectBuilder;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

@SuppressWarnings("unused")
public class ButtonBuilder extends RenderableObjectBuilder<Button, ButtonBuilder> {
	private ArrayList<Task> taskList = new ArrayList<>();
	private BufferedImage[] imgs;
	public ButtonBuilder(Interface i, String imgPath) {
		super(i, imgPath);
		imgs = new BufferedImage[]{img, img, img};
	}
	@Override
	public ButtonBuilder y(int objY) {
		return super.setY(objY);
	}
	@Override
	public ButtonBuilder x(int objX) {
		return super.setX(objX);
	}
	public ButtonBuilder onClick(Task t) {
		taskList.add(t);
		return this;
	}
	public ButtonBuilder hoverImg(String imgPath) {
		imgs[1] = BufferedImageManager.getImage(imgPath);
		return this;
	}
	public ButtonBuilder clickImg(String imgPath) {
		imgs[2] = BufferedImageManager.getImage(imgPath);
		return this;
	}
	@Override
	public Button build() {
		return super.render(new Button(imgs, x, y, taskList));
	}
}
