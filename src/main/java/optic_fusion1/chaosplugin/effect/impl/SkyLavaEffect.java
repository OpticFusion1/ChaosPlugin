package optic_fusion1.chaosplugin.effect.impl;

import optic_fusion1.chaosplugin.effect.Effect;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;

public class SkyLavaEffect extends Effect {

  public SkyLavaEffect() {
    super("SkyLava");
  }

  @Override
  public void activate(Player player) {
    new Location(player.getWorld(), player.getLocation().getX(), 255.0, player.getLocation().getZ())
            .getBlock().setType(Material.LAVA);
  }

}
