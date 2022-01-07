package optic_fusion1.chaosplugin.effect.impl;

import optic_fusion1.chaosplugin.effect.Effect;
import optic_fusion1.chaosplugin.util.Utils;
import org.bukkit.Location;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Parrot;
import org.bukkit.entity.Player;

public class WingManEffect extends Effect {

  public WingManEffect() {
    super("Wing Man");
  }

  @Override
  public void activate(Player player) {
    Location location = Utils.getLocationInCircle(player.getLocation(), 10);
    location.setY(location.getWorld().getHighestBlockYAt(location) + 1);
    Parrot parrot = (Parrot) location.getWorld().spawnEntity(location, EntityType.PARROT);
    parrot.setOwner(player);
    parrot.setTamed(true);
  }

}
