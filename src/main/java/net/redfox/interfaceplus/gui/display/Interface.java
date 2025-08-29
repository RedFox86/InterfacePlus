package net.redfox.interfaceplus.gui.display;

import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;
import net.redfox.interfaceplus.gui.DisplayPanel;
import net.redfox.interfaceplus.gui.util.WindowContext;
import net.redfox.interfaceplus.object.Renderer;
import net.redfox.interfaceplus.task.Task;

public class Interface {
    private static int totalInterfaces = 0;
    private final int identifier;
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

        identifier = totalInterfaces;
        totalInterfaces++;
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

    public int getIdentifier() {
        return identifier;
    }

    public static class Builder {
        private String title;
        private Dimension size;
        private Color background;
        private int FPS;

        public Builder() {
            title = "Untitled";
            size = new Dimension(1920, 1080);
            background = Color.WHITE;
            FPS = 60;
        }

        public Builder title(String title) {
            this.title = title;
            return this;
        }

        public Builder color(Color background) {
            this.background = background;
            return this;
        }

        public Builder size(Dimension size) {
            this.size = size;
            return this;
        }

        public Builder FPS(int FPS) {
            this.FPS = FPS;
            return this;
        }

        public Interface build() {
            return new Interface(title, size, background, FPS);
        }
    }
}
