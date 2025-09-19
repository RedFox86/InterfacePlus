package net.redfox.interfaceplus.task;

import net.redfox.interfaceplus.object.util.animated.NodePanel;

public class NpTask implements Task {
  private final NodePanel np;

  public NpTask(NodePanel np) {
    this.np = np;
  }

  @Override
  public void execute() {
    np.next();
  }
}
