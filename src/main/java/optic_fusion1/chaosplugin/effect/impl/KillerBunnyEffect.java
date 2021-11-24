package optic_fusion1.chaosplugin.effect.impl;

import optic_fusion1.chaosplugin.effect.Effect;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.entity.Rabbit;

public class KillerBunnyEffect extends Effect {

  public KillerBunnyEffect() {
    super("Killer Bunny");
  }

  @Override
  public void activate(Player player) {
    Rabbit rabbit = (Rabbit) player.getWorld().spawnEntity(player.getLocation(), EntityType.RABBIT);
    rabbit.setRabbitType(Rabbit.Type.THE_KILLER_BUNNY);
    rabbit.setTarget(player);
  }

}
