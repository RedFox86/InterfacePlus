package net.redfox.interfaceplus.objects.util.animated;

import net.redfox.interfaceplus.BufferedImageManager;
import net.redfox.interfaceplus.Logger;
import net.redfox.interfaceplus.gui.display.Interface;
import net.redfox.interfaceplus.objects.RenderableObjectBuilder;

import java.awt.image.BufferedImage;

public class NodePanelBuilder extends RenderableObjectBuilder<NodePanel, NodePanelBuilder> {
	private final BufferedImage[] imageList;
	private boolean repeat;
	public NodePanelBuilder(Interface i, String[] nodePanelImageList) {
		super(i, nodePanelImageList[0]);
		imageList = new BufferedImage[nodePanelImageList.length];
		for (int j = 0; j < nodePanelImageList.length; j++) {
			imageList[j] = BufferedImageManager.getImage(nodePanelImageList[j]);
		}
	}
	public NodePanelBuilder repeat(boolean objectRepeat) {
		repeat = objectRepeat;
		return this;
	}

	@Override
	public NodePanelBuilder x(int objX) {
		return super.setX(objX);
	}

	@Override
	public NodePanelBuilder y(int objY) {
		return super.setY(objY);
	}

	@Override
	public NodePanel build() {
		Logger.log("Node Panel successfully built.");
		return super.build(new NodePanel(imageList, x, y, repeat));
	}
}
