package optic_fusion1.chaosplugin.effect.impl;

import optic_fusion1.chaosplugin.effect.Effect;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.entity.Bee;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;

public class SummonAngryBeeEffect extends Effect {

  public SummonAngryBeeEffect() {
    super("Summon Angry Bee");
  }

  @Override
  public void activate(Player player) {
    Location location = player.getLocation().add(0.0, 4.0, 0.0);
    Bee bee = (Bee) location.getWorld().spawnEntity(location, EntityType.BEE);
    bee.setCustomName(ChatColor.RED + "Angry Bee");
    bee.setCustomNameVisible(true);
    bee.setAnger(100000);
    bee.setTarget(player);
  }

}
