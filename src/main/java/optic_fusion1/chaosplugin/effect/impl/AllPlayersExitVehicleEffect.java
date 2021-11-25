package optic_fusion1.chaosplugin.effect.impl;

import optic_fusion1.chaosplugin.effect.Effect;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class AllPlayersExitVehicleEffect extends Effect {

  public AllPlayersExitVehicleEffect() {
    super("All Players Exit Vehicle", true);
  }

  @Override
  public void activate(Player player) {
    for (Player target : Bukkit.getOnlinePlayers()) {
      if (target.isInsideVehicle()) {
        target.eject();
      }
    }
  }

}
