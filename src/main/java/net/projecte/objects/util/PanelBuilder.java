package net.projecte.objects.util;

import net.projecte.Logger;
import net.projecte.gui.display.Interface;
import net.projecte.objects.RenderableObjectBuilder;

public class PanelBuilder extends RenderableObjectBuilder<Panel, PanelBuilder> {
	/**
	 *
	 * @param panelBuilderInterface The interface that the Panel will be displayed on - used to add to the objects list in Renderer.
	 * @param imagePath The path for the image that will be loaded and displayed on the screen.
	 */
	public PanelBuilder(Interface panelBuilderInterface, String imagePath) {
		super(panelBuilderInterface, imagePath);
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
		return super.build(new Panel(displayImage, x, y));
	}
}
