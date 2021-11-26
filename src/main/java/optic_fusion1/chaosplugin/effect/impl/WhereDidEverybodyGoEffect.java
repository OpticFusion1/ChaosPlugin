package optic_fusion1.chaosplugin.effect.impl;

import optic_fusion1.chaosplugin.ChaosPlugin;
import optic_fusion1.chaosplugin.effect.TimedEffect;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class WhereDidEverybodyGoEffect extends TimedEffect {

  private ChaosPlugin chaos;

  public WhereDidEverybodyGoEffect(ChaosPlugin chaos) {
    super("Where did everybody go?");
    this.chaos = chaos;
  }

  @Override
  public void deactivate(Player player) {
    for (Player target : Bukkit.getOnlinePlayers()) {
      player.showPlayer(chaos, target);
    }
  }

  @Override
  public void activate(Player player) {
    for (Player target : Bukkit.getOnlinePlayers()) {
      player.hidePlayer(chaos, target);
    }
  }

}
