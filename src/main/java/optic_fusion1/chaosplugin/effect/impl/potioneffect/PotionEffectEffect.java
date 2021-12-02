package optic_fusion1.chaosplugin.effect.impl.potioneffect;

import java.util.HashMap;
import optic_fusion1.chaosplugin.ChaosPlugin;
import optic_fusion1.chaosplugin.effect.TimedEffect;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.HandlerList;
import org.bukkit.event.Listener;
import org.bukkit.potion.PotionEffect;

public class PotionEffectEffect extends TimedEffect implements Listener {

  private PotionEffect potionEffect;
  private ChaosPlugin chaos;
  private static final HashMap<Player, PotionEffectEffectListener> LISTENERS = new HashMap<>();

  public PotionEffectEffect(String name, PotionEffect potionEffect, ChaosPlugin chaos) {
    super(name);
    this.potionEffect = potionEffect;
    this.chaos = chaos;
  }

  @Override
  public void deactivate(Player player) {
    player.removePotionEffect(potionEffect.getType());
    HandlerList.unregisterAll(LISTENERS.get(player));
  }

  @Override
  public void activate(Player player) {
    player.addPotionEffect(potionEffect);
    PotionEffectEffectListener listener = new PotionEffectEffectListener(chaos, potionEffect, player);
    if (LISTENERS.containsKey(player)) {
      HandlerList.unregisterAll(LISTENERS.get(player));
      LISTENERS.remove(player);
    }
    LISTENERS.put(player, listener);
    Bukkit.getPluginManager().registerEvents(listener, chaos);
  }

}
