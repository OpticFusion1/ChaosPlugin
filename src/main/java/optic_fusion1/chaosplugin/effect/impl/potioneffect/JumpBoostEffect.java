package optic_fusion1.chaosplugin.effect.impl.potioneffect;

import optic_fusion1.chaosplugin.ChaosPlugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class JumpBoostEffect extends PotionEffectEffect {

  public JumpBoostEffect(ChaosPlugin chaos) {
    super("Jump Boost", new PotionEffect(PotionEffectType.JUMP, Integer.MAX_VALUE, 50), chaos);
  }

}
