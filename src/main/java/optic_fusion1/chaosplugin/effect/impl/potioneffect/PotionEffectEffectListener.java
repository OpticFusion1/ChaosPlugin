package optic_fusion1.chaosplugin.effect.impl.potioneffect;

import optic_fusion1.chaosplugin.ChaosPlugin;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.potion.PotionEffect;

public class PotionEffectEffectListener implements Listener {

  private ChaosPlugin chaos;
  private PotionEffect potionEffect;
  private Player player;

  public PotionEffectEffectListener(ChaosPlugin chaos, PotionEffect potionEffect, Player player) {
    this.chaos = chaos;
    this.potionEffect = potionEffect;
    this.player = player;
  }

  @EventHandler
  public void on(PlayerRespawnEvent event) {
    Bukkit.getScheduler().scheduleSyncDelayedTask(chaos, () -> {
      event.getPlayer().addPotionEffect(potionEffect);
    }, 1L);
  }

  @EventHandler
  public void on(PlayerQuitEvent event) {
    event.getPlayer().removePotionEffect(potionEffect.getType());
  }

}
