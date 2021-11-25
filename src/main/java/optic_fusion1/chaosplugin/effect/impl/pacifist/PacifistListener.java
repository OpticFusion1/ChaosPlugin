package optic_fusion1.chaosplugin.effect.impl.pacifist;

import optic_fusion1.chaosplugin.ChaosPlugin;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

public class PacifistListener implements Listener {

  private ChaosPlugin chaos;

  public PacifistListener(ChaosPlugin chaos) {
    this.chaos = chaos;
  }

  @EventHandler
  public void on(EntityDamageByEntityEvent event) {
    if (event.getDamager().getType() == EntityType.PLAYER) {
      return;
    }
    Player damager = (Player) event.getDamager();
    if (!chaos.isPacifistEffectEnabledForPlayer(damager)) {
      return;
    }
    damager.setFireTicks(1000);
    damager.setHealth(0);
  }

}
