package optic_fusion1.chaosplugin.effect.impl;

import optic_fusion1.chaosplugin.effect.TimedEffect;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class JumpBoostEffect extends TimedEffect {

  public JumpBoostEffect() {
    super("JumpBoostEffect");
  }

  @Override
  public void deactivate(Player player) {
    player.removePotionEffect(PotionEffectType.JUMP);
  }

  @Override
  public void activate(Player player) {
    player.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, Integer.MAX_VALUE, 50));
  }

}
