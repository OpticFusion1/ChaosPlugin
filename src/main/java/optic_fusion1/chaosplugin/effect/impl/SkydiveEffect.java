package optic_fusion1.chaosplugin.effect.impl;

import optic_fusion1.chaosplugin.effect.Effect;
import org.bukkit.entity.Player;

public class SkydiveEffect extends Effect {

  public SkydiveEffect() {
    super("Heaven");
  }

  @Override
  public void activate(Player player) {
    player.teleport(player.getLocation().add(0, 100, 0));
  }

}
