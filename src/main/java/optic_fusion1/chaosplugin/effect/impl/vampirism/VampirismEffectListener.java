package optic_fusion1.chaosplugin.effect.impl.vampirism;

import optic_fusion1.chaosplugin.ChaosPlugin;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityRegainHealthEvent;

public class VampirismEffectListener implements Listener {

    private ChaosPlugin chaos;

    public VampirismEffectListener(ChaosPlugin chaos) {
        this.chaos = chaos;
    }

    @EventHandler
    public void on(EntityRegainHealthEvent event) {
        if (event.getEntityType() != EntityType.PLAYER) {
            return;
        }
        Player player = (Player) event.getEntity();
        if (chaos.isVampirismEffectEnabledForPlayer(player)) {
            event.setCancelled(true);
        }
    }

    @EventHandler
    public void on(EntityDamageByEntityEvent event) {
        if (event.getDamager().getType() != EntityType.PLAYER) {
            return;
        }
        Player damager = (Player) event.getDamager();
        if (!chaos.isVampirismEffectEnabledForPlayer(damager)) {
            return;
        }
        if (damager.getHealth() >= 20) {
            return;
        }
        damager.setHealth(damager.getHealth() + 1);
    }

}
