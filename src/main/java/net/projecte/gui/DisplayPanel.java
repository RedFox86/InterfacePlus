package net.projecte.gui;

import net.projecte.gui.Interface;
import net.projecte.objects.Renderer;

import javax.swing.*;
import java.awt.*;

public class DisplayPanel extends JPanel implements Runnable {
	final Dimension SCREEN_SIZE;
	final int FPS;

//	KeyHandler key = new KeyHandler();
	Thread gameThread;
	Interface panelInterface;
	Renderer renderer;

	public DisplayPanel(Interface i, int fps, Dimension size) {
		SCREEN_SIZE = size;
		FPS = fps;
		this.setDoubleBuffered(true);
//		this.addKeyListener(key);
		this.setFocusable(true);
		this.panelInterface = i;
		this.renderer = new Renderer();
	}
	public void startGameThread() {
		gameThread = new Thread(this);
		gameThread.start();
	}

	@Override
	public void run() {
		double drawInterval = 1000000000.0/FPS;
		double delta = 0;
		long lastTime = System.nanoTime();
		long currentTime;
		long timer = 0;

		while (gameThread != null) {
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
		panelInterface.updateImages(g2);
		g2.dispose();
	}
}