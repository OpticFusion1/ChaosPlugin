package optic_fusion1.chaosplugin.effect.impl;

import optic_fusion1.chaosplugin.effect.Effect;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.util.Vector;

public class LaunchPlayerEffect extends Effect {

  public LaunchPlayerEffect() {
    super("Launch Player");
  }

  @Override
  public void activate(Player player) {
    Location location = player.getLocation();
    location.setPitch(-90);
    player.teleport(location);
    Vector direction = location.getDirection();
    player.setVelocity(direction.multiply(50.0));
  }

}
