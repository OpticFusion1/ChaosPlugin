package optic_fusion1.chaosplugin.effect.impl;

import java.util.ArrayList;
import java.util.List;
import optic_fusion1.chaosplugin.effect.TimedEffect;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;

public class InvisibleEntitiesEffect extends TimedEffect implements Listener {

  private List<LivingEntity> invisibleEntities = new ArrayList<>();

  public InvisibleEntitiesEffect() {
    super("Invisible Entities");
  }

  @Override
  public void deactivate(Player player) {
    for (LivingEntity entity : invisibleEntities) {
      entity.setInvisible(false);
    }
  }

  @Override
  public void activate(Player player) {
    for (Entity entity : player.getWorld().getEntities()) {
      if (entity instanceof LivingEntity livingEntity) {
        livingEntity.setInvisible(true);
        invisibleEntities.add(livingEntity);
      }
    }
  }

  @EventHandler
  public void on(EntityDeathEvent event) {
    if (invisibleEntities.contains(event.getEntity())) {
      invisibleEntities.remove(event.getEntity());
    }
  }

}
