package optic_fusion1.chaosplugin.effect.impl;

import optic_fusion1.chaosplugin.effect.Effect;
import org.bukkit.entity.Player;

public class LightningEffect extends Effect {

  public LightningEffect() {
    super("LightningEffect");
  }

  @Override
  public void activate(Player player) {
    player.getWorld().strikeLightning(player.getLocation());
  }

}
