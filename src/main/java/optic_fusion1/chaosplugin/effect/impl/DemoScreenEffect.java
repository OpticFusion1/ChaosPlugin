package optic_fusion1.chaosplugin.effect.impl;

import optic_fusion1.chaosplugin.effect.Effect;
import org.bukkit.entity.Player;

public class DemoScreenEffect extends Effect {

  public DemoScreenEffect() {
    super("Demo Screen");
  }

  @Override
  public void activate(Player player) {
    player.showDemoScreen();
  }

}
