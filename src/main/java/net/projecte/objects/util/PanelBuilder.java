package net.projecte.objects.util;

import net.projecte.Logger;
import net.projecte.gui.display.Interface;
import net.projecte.objects.RenderableObjectBuilder;

public class PanelBuilder extends RenderableObjectBuilder<Panel, PanelBuilder> {
	public PanelBuilder(Interface i, String imgPath) {
		super(i, imgPath);
	}

	@Override
	public PanelBuilder x(int bX) {
		return super.setX(bX);
	}

	@Override
	public PanelBuilder y(int bY) {
		return super.setY(bY);
	}

	@Override
	public Panel build() {
		Logger.log("Panel successfully built.");
		return super.build(new Panel(img, x, y));
	}
}
