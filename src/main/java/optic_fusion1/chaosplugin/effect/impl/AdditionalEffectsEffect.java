package optic_fusion1.chaosplugin.effect.impl;

import optic_fusion1.chaosplugin.ChaosPlugin;
import optic_fusion1.chaosplugin.effect.Effect;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class AdditionalEffectsEffect extends Effect {

  private ChaosPlugin plugin;

  public AdditionalEffectsEffect(ChaosPlugin plugin) {
    super("AdditionalEffectsEffect");
    this.plugin = plugin;
  }

  @Override
  public void activate(Player player) {
    for (int i = 0; i <= 2; i++) {
      for (Player target : Bukkit.getOnlinePlayers()) {
        plugin.runRandomEffect(target);
      }
    }
  }

}
