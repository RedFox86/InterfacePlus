package net.redfox.interfaceplus.object.util;

import net.redfox.interfaceplus.util.Logger;
import net.redfox.interfaceplus.gui.display.Interface;
import net.redfox.interfaceplus.object.RenderableObjectBuilder;

public class PanelBuilder extends RenderableObjectBuilder<Panel, PanelBuilder> {
	/**
	 *
	 * @param bInterface The interface that the Panel will be displayed on - used to add to the objects list in Renderer.
	 * @param imagePath The path for the image that will be loaded and displayed on the screen.
	 */
	public PanelBuilder(Interface bInterface, String imagePath) {
		super(bInterface, imagePath);
	}

	@Override
	public PanelBuilder x(int x) {
		return super.setX(x);
	}

	@Override
	public PanelBuilder y(int y) {
		return super.setY(y);
	}
	@Override
	public Panel build() {
		Logger.log("Panel successfully built.");
		return super.build(new Panel(displayImage, x, y));
	}
}
