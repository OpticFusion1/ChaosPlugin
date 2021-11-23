package optic_fusion1.chaosplugin.effect.impl;

import java.util.concurrent.ThreadLocalRandom;
import optic_fusion1.chaosplugin.effect.Effect;
import org.bukkit.TreeType;
import org.bukkit.entity.Player;

public class SummonTreeEffect extends Effect {

  public SummonTreeEffect() {
    super("SummonTreeEffect");
  }

  @Override
  public void activate(Player player) {
    player.getWorld().generateTree(player.getLocation(), TreeType.values()[ThreadLocalRandom.current().nextInt(TreeType.values().length)]);
  }

}
