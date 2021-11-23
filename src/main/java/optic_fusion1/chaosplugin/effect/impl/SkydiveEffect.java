package optic_fusion1.chaosplugin.effect.impl;

import optic_fusion1.chaosplugin.effect.Effect;
import org.bukkit.Location;
import org.bukkit.entity.Player;

public class SkydiveEffect extends Effect {

  public SkydiveEffect() {
    super("SkydiveEffect");
  }

  @Override
  public void activate(Player player) {
    Location location = player.getLocation().add(0, 100, 0);
    player.teleport(location);
  }
  
  /*
Location location = new Location(target.getWorld(), 
  target.getLocation().getX(), target.getLocation().getY() + 100.0, target.getLocation().getZ());
target.teleport(location);

  */

}
