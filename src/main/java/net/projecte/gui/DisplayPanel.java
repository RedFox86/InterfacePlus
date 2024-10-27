package net.projecte.gui;

import net.projecte.gui.display.Interface;
import net.projecte.gui.util.KeyHandler;
import net.projecte.gui.util.MouseHandler;
import net.projecte.gui.util.WindowContext;
import net.projecte.objects.Renderer;

import javax.swing.*;
import java.awt.*;

public class DisplayPanel extends JPanel implements Runnable {
	public final Dimension SCREEN_SIZE;
	final int FPS;

	Thread thread;
	Interface panelInterface;
	WindowContext context;
	public Renderer renderer;

	public DisplayPanel(Interface i, int fps, Dimension size) {
		SCREEN_SIZE = size;
		FPS = fps;
		context = new WindowContext(null, null);
		this.setDoubleBuffered(true);
		this.addKeyListener(new KeyHandler());
		this.addMouseListener(new MouseHandler());
		this.setFocusable(true);
		this.panelInterface = i;
		this.renderer = new Renderer();
	}
	public void startGameThread() {
		thread = new Thread(this);
		thread.start();
	}

	@Override
	public void run() {
		double drawInterval = 1000000000.0/FPS;
		double delta = 0;
		long lastTime = System.nanoTime();
		long currentTime;
		long timer = 0;

		while (thread != null) {
			currentTime = System.nanoTime();
			delta += (currentTime - lastTime) / drawInterval;
			timer += (currentTime - lastTime);
			lastTime = currentTime;

			if (delta >= 1) {
				panelInterface.update();
				repaint();

				delta--;
			}
			if (timer >= 1000000000) {
				timer = 0;
			}
		}
	}
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D)g;
		context.setG2(g2);
		context.setLocation(this.getLocationOnScreen());
		panelInterface.updateImages(context);
		g2.dispose();
	}
}