package optic_fusion1.chaosplugin.effect.impl;

import optic_fusion1.chaosplugin.effect.Effect;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffectType;

public class ClearPotionEffectsEffect extends Effect {

  public ClearPotionEffectsEffect() {
    super("Clear Potion Effects");
  }

  @Override
  public void activate(Player player) {
    for (PotionEffectType effect : PotionEffectType.values()) {
      player.removePotionEffect(effect);
    }
  }

}
