package optic_fusion1.chaosplugin.effect.impl;

import optic_fusion1.chaosplugin.effect.Effect;
import org.bukkit.Material;
import org.bukkit.entity.Player;

public class IgniteEffect extends Effect {

  public IgniteEffect() {
    super("Ignite");
  }

  @Override
  public void activate(Player player) {
    player.getLocation().getBlock().setType(Material.FIRE);
  }

}
