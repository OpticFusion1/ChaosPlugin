package optic_fusion1.chaosplugin.effect.impl;

import optic_fusion1.chaosplugin.effect.TimedEffect;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class HasteEffect extends TimedEffect {

  public HasteEffect() {
    super("HasteEffect");
  }

  @Override
  public void deactivate(Player player) {
    player.removePotionEffect(PotionEffectType.FAST_DIGGING);
  }

  @Override
  public void activate(Player player) {
    player.addPotionEffect(new PotionEffect(PotionEffectType.FAST_DIGGING, Integer.MAX_VALUE, 255));
  }

}
