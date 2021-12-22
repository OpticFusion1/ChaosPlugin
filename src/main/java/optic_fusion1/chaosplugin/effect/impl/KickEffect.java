package optic_fusion1.chaosplugin.effect.impl;

import optic_fusion1.chaosplugin.effect.Effect;
import org.bukkit.entity.Player;

public class KickEffect extends Effect {

  public KickEffect() {
    super("Kick");
  }

  @Override
  public void activate(Player player) {
    player.kickPlayer("You have been kicked");
  }

}
