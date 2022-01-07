package optic_fusion1.chaosplugin.effect.impl;

import optic_fusion1.chaosplugin.effect.Effect;
import optic_fusion1.chaosplugin.util.Utils;
import org.bukkit.Location;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.entity.Wolf;

public class DogLoverEffect extends Effect {

  public DogLoverEffect() {
    super("Dog Lover");
  }

  @Override
  public void activate(Player player) {
    for (int i = 0; i <= 10; i++) {
      Location location = Utils.getLocationInCircle(player.getLocation(), 10);
      location.setY(location.getWorld().getHighestBlockYAt(location) + 1);
      Wolf wolf = (Wolf) location.getWorld().spawnEntity(location, EntityType.WOLF);
      wolf.setOwner(player);
      wolf.setTamed(true);
    }
  }

}
