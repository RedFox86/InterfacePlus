package net.redfox.interfaceplus.gui.display;

import net.redfox.interfaceplus.task.Task;
import net.redfox.interfaceplus.gui.DisplayPanel;
import net.redfox.interfaceplus.gui.util.WindowContext;
import net.redfox.interfaceplus.object.Renderer;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Interface {
	private final ArrayList<Task> taskList = new ArrayList<>();
	private final JFrame window;
	private final DisplayPanel panel;

	protected Interface(String title, Dimension size, Color background, int FPS) {
		window = new JFrame();
		window.setResizable(false);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		panel = new DisplayPanel(this, FPS, size);
		window.add(panel);
		window.setTitle(title);
		panel.setBackground(background);
		panel.setPreferredSize(size);
		window.pack();
		window.setLocationRelativeTo(null);

		window.setVisible(true);

		panel.startGameThread();
	}

	public void update() {
		for (Task t : taskList) {
			t.execute();
		}
	}
	public void updateImages(WindowContext context) {
		panel.renderer.renderObjects(context);
	}
	public void addTask(Task t) {
		taskList.add(t);
	}
	public Renderer getRenderer() {
		return panel.renderer;
	}
}