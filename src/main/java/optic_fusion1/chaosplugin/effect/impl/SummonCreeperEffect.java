package optic_fusion1.chaosplugin.effect.impl;

import optic_fusion1.chaosplugin.effect.Effect;
import optic_fusion1.chaosplugin.util.Utils;
import org.bukkit.Location;
import org.bukkit.entity.Creeper;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;

public class SummonCreeperEffect extends Effect {

  public SummonCreeperEffect() {
    super("Summon Creeper");
  }

  @Override
  public void activate(Player player) {
    Location location = Utils.getLocationInCircle(player.getLocation(), 10);
    location.setY(location.getWorld().getHighestBlockYAt(location) + 1);
    Creeper creeper = (Creeper) location.getWorld().spawnEntity(location, EntityType.CREEPER);
    creeper.setTarget(player);
  }

}
