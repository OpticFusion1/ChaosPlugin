package optic_fusion1.chaosplugin.effect.impl;

import optic_fusion1.chaosplugin.effect.Effect;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.entity.Player;

public class LightningEffect extends Effect {

  public LightningEffect() {
    super("LightningEffect");
  }

  @Override
  public void activate(Player player) {
    World world = player.getWorld();
    world.playSound(player.getLocation(), Sound.ENTITY_LIGHTNING_BOLT_THUNDER, 1.0f, 1.0f);
    world.strikeLightning(player.getLocation());
    world.playSound(player.getLocation(), Sound.ENTITY_LIGHTNING_BOLT_IMPACT, 1.0f, 1.0f);
  }

}
