package optic_fusion1.chaosplugin.effect.impl.potioneffect;

import optic_fusion1.chaosplugin.ChaosPlugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class HasteEffect extends PotionEffectEffect {

  public HasteEffect(ChaosPlugin chaos) {
    super("Haste", new PotionEffect(PotionEffectType.FAST_DIGGING, Integer.MAX_VALUE, 255), chaos);
  }

}
