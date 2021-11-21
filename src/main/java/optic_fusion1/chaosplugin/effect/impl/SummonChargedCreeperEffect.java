package optic_fusion1.chaosplugin.effect.impl;

import optic_fusion1.chaosplugin.effect.Effect;
import org.bukkit.Location;
import org.bukkit.entity.Creeper;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;

public class SummonChargedCreeperEffect extends Effect {

  public SummonChargedCreeperEffect() {
    super("SummonChargedCreeperEffect");
  }

  @Override
  public void activate(Player player) {
    Location location = player.getLocation().add(1.0, 1.0, 1.0);
    Creeper creeper = (Creeper) location.getWorld().spawnEntity(location, EntityType.CREEPER);
    creeper.setPowered(true);
  }

}
