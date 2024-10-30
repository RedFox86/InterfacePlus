package net.projecte.objects.util;

import net.projecte.Logger;
import net.projecte.gui.display.Interface;
import net.projecte.objects.RenderableObjectBuilder;

public class PanelBuilder extends RenderableObjectBuilder<Panel, PanelBuilder> {
	public PanelBuilder(Interface i, String imgPath) {
		super(i, imgPath);
	}

	@Override
	public PanelBuilder x(int objX) {
		return super.setX(objX);
	}

	@Override
	public PanelBuilder y(int objY) {
		return super.setY(objY);
	}

	@Override
	public Panel build() {
		Logger.log("Panel successfully built.");
		return super.build(new Panel(img, x, y));
	}
}
