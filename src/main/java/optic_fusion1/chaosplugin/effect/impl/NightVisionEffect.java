package optic_fusion1.chaosplugin.effect.impl;

import optic_fusion1.chaosplugin.effect.TimedEffect;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class NightVisionEffect extends TimedEffect {

  public NightVisionEffect() {
    super("NightVisionEffect");
  }

  @Override
  public void deactivate(Player player) {
    player.removePotionEffect(PotionEffectType.NIGHT_VISION);
  }

  @Override
  public void activate(Player player) {
    player.addPotionEffect(new PotionEffect(PotionEffectType.NIGHT_VISION, Integer.MAX_VALUE, 1));
  }

}
