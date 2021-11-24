package optic_fusion1.chaosplugin.effect.impl;

import optic_fusion1.chaosplugin.effect.Effect;
import optic_fusion1.chaosplugin.util.Utils;
import org.bukkit.Location;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.entity.Vindicator;

public class HeresJohnnyEffect extends Effect {

  public HeresJohnnyEffect() {
    super("Here's Johnny");
  }

  @Override
  public void activate(Player player) {
    Location location = Utils.getLocationInCircle(player.getLocation(), 10);
    location.setY(location.getWorld().getHighestBlockYAt(location) + 1);
    Vindicator vindicator = (Vindicator) player.getWorld().spawnEntity(location, EntityType.VINDICATOR);
    vindicator.setCustomName("Johnny");
    vindicator.setCustomNameVisible(true);
    vindicator.setTarget(player);
  }

}
