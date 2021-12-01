package optic_fusion1.chaosplugin.effect.impl.potioneffect;

import optic_fusion1.chaosplugin.ChaosPlugin;
import optic_fusion1.chaosplugin.effect.TimedEffect;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.HandlerList;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.potion.PotionEffect;

public class PotionEffectEffect extends TimedEffect implements Listener {

  private PotionEffect potionEffect;
  private ChaosPlugin chaos;

  public PotionEffectEffect(String name, PotionEffect potionEffect, ChaosPlugin chaos) {
    super(name);
    this.potionEffect = potionEffect;
    this.chaos = chaos;
  }

  @Override
  public void deactivate(Player player) {
    player.removePotionEffect(potionEffect.getType());
    HandlerList.unregisterAll(this);
  }

  @Override
  public void activate(Player player) {
    player.addPotionEffect(potionEffect);
    Bukkit.getPluginManager().registerEvents(this, chaos);
  }

  @EventHandler
  public void on(PlayerRespawnEvent event) {
    event.getPlayer().addPotionEffect(potionEffect);
  }

  @EventHandler
  public void on(PlayerQuitEvent event) {
    event.getPlayer().removePotionEffect(potionEffect.getType());
  }

}
