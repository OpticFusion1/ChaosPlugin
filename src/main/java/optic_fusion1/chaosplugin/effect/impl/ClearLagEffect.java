package optic_fusion1.chaosplugin.effect.impl;

import optic_fusion1.chaosplugin.effect.Effect;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;

public class ClearLagEffect extends Effect {

  public ClearLagEffect() {
    super("ClearLagEffect");
  }

  @Override
  public void activate(Player player) {
    for (Entity entity : player.getWorld().getEntities()) {
      if (entity instanceof Item) {
        entity.remove();
      }
    }
  }

}
