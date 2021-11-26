package optic_fusion1.chaosplugin.effect.impl;

import optic_fusion1.chaosplugin.effect.Effect;
import optic_fusion1.chaosplugin.util.Utils;
import org.bukkit.entity.Player;

public class LaunchPlayerEffect extends Effect {

  public LaunchPlayerEffect() {
    super("Launch Player");
  }

  @Override
  public void activate(Player player) {
    Utils.launchEntity(player);
  }

}
