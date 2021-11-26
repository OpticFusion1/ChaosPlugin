package optic_fusion1.chaosplugin.effect.impl;

import optic_fusion1.chaosplugin.ChaosPlugin;
import optic_fusion1.chaosplugin.effect.Effect;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class ComboTimeEffect extends Effect {

  private ChaosPlugin chaos;

  public ComboTimeEffect(ChaosPlugin chaos) {
    super("Combo Time");
    this.chaos = chaos;
  }

  @Override
  public void activate(Player player) {
    for (int i = 0; i <= 1; i++) {
      for (Player target : Bukkit.getOnlinePlayers()) {
        chaos.runRandomEffect(target);
      }
    }
  }

}
