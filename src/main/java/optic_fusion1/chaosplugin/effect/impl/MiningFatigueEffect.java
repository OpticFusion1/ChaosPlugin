package optic_fusion1.chaosplugin.effect.impl;

import optic_fusion1.chaosplugin.effect.TimedEffect;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class MiningFatigueEffect extends TimedEffect {

  public MiningFatigueEffect() {
    super("Slooooow mining");
  }

  @Override
  public void deactivate(Player player) {
    player.removePotionEffect(PotionEffectType.SLOW_DIGGING);
  }

  @Override
  public void activate(Player player) {
    player.addPotionEffect(new PotionEffect(PotionEffectType.SLOW_DIGGING, Integer.MAX_VALUE, 255));
  }
}
