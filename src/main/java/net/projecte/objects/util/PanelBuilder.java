package net.projecte.objects.util;

import net.projecte.gui.Interface;
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
		return super.render(new Panel(img, x, y));
	}
}
