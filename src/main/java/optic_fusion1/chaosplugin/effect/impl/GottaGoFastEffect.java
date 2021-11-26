package optic_fusion1.chaosplugin.effect.impl;

import optic_fusion1.chaosplugin.effect.TimedEffect;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class GottaGoFastEffect extends TimedEffect {

  public GottaGoFastEffect() {
    super("Gotta go fast");
  }

  @Override
  public void deactivate(Player player) {
    player.removePotionEffect(PotionEffectType.SPEED);
  }

  @Override
  public void activate(Player player) {
    player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, Integer.MAX_VALUE, 255));
  }

}
