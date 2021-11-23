package optic_fusion1.chaosplugin.effect.impl;

import optic_fusion1.chaosplugin.effect.TimedEffect;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class BlindnessEffect extends TimedEffect {

  public BlindnessEffect() {
    super("BlindnessEffect");
  }

  @Override
  public void deactivate(Player player) {
    player.removePotionEffect(PotionEffectType.BLINDNESS);
  }

  @Override
  public void activate(Player player) {
    player.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, Integer.MAX_VALUE, 1));
  }

}
