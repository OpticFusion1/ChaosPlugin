package optic_fusion1.chaosplugin.effect.impl.potioneffect;

import optic_fusion1.chaosplugin.ChaosPlugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class BlindnessEffect extends PotionEffectEffect {

    public BlindnessEffect(ChaosPlugin chaos) {
        super("Blindness", new PotionEffect(PotionEffectType.BLINDNESS, Integer.MAX_VALUE, 1), chaos);
    }

}
