package optic_fusion1.chaosplugin.effect.impl;

import optic_fusion1.chaosplugin.effect.Effect;
import org.bukkit.entity.Player;

public class HalfHeartEffect extends Effect {

  public HalfHeartEffect() {
    super("Half a heart");
  }

  @Override
  public void activate(Player player) {
    player.setHealth(1.0);
  }

}
