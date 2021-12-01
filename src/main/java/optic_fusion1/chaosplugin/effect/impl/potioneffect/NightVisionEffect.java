package optic_fusion1.chaosplugin.effect.impl.potioneffect;

import optic_fusion1.chaosplugin.ChaosPlugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class NightVisionEffect extends PotionEffectEffect {

  public NightVisionEffect(ChaosPlugin chaos) {
    super("Night Vision", new PotionEffect(PotionEffectType.NIGHT_VISION, Integer.MAX_VALUE, 1), chaos);
  }

}
