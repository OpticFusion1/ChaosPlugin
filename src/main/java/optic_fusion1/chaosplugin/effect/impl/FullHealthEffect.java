package optic_fusion1.chaosplugin.effect.impl;

import optic_fusion1.chaosplugin.effect.Effect;
import org.bukkit.entity.Player;

public class FullHealthEffect extends Effect {

  public FullHealthEffect() {
    super("Full Health");
  }

  @Override
  public void activate(Player player) {
    player.setHealth(20.0);
  }

}
