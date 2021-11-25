package optic_fusion1.chaosplugin.effect.impl;

import java.util.ArrayList;
import java.util.List;
import optic_fusion1.chaosplugin.effect.TimedEffect;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;

public class InvulnerableEntitiesEffect extends TimedEffect {

  private List<LivingEntity> invulnerableEntities = new ArrayList<>();

  public InvulnerableEntitiesEffect() {
    super("Invulnerable Entities", true);
  }
  
  @Override
  public void activate(Player player) {
    for (Entity entity : player.getWorld().getEntities()) {
      if (entity instanceof LivingEntity) {
        entity.setInvulnerable(true);
        invulnerableEntities.add((LivingEntity) entity);
      }
    }
  }

  @Override
  public void deactivate(Player player) {
    for (Entity entity : invulnerableEntities) {
      if (entity.isInvulnerable()) {
        entity.setInvulnerable(false);
      }
    }
  }

}
