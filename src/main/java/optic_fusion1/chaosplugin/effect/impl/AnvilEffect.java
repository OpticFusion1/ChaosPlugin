package optic_fusion1.chaosplugin.effect.impl;

import optic_fusion1.chaosplugin.effect.Effect;
import org.bukkit.Material;
import org.bukkit.entity.Player;

public class AnvilEffect extends Effect {

  public AnvilEffect() {
    super("Watch out");
  }

  @Override
  public void activate(Player player) {
    player.getLocation().add(0.0, 12.0, 0.0).getBlock().setType(Material.ANVIL);
  }

}
