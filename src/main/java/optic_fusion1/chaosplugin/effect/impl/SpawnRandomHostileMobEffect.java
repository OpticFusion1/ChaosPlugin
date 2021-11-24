package optic_fusion1.chaosplugin.effect.impl;

import java.util.EnumSet;
import optic_fusion1.chaosplugin.effect.Effect;
import org.bukkit.entity.CaveSpider;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;

public class SpawnRandomHostileMobEffect extends Effect {

  private static final EnumSet<EntityType> ENTITY_TYPES = EnumSet.of(EntityType.CAVE_SPIDER);
  
  public SpawnRandomHostileMobEffect() {
    super("Spawn Random Hostile Mob");
  }

  @Override
  public void activate(Player player) {
  }

}
