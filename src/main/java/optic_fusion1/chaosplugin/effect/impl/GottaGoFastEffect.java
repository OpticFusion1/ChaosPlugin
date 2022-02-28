package optic_fusion1.chaosplugin.effect.impl;

import optic_fusion1.chaosplugin.ChaosPlugin;
import optic_fusion1.chaosplugin.effect.impl.potioneffect.PotionEffectEffect;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class GottaGoFastEffect extends PotionEffectEffect {

    public GottaGoFastEffect(ChaosPlugin chaos) {
        super("Gotta Go Fast", new PotionEffect(PotionEffectType.SPEED, Integer.MAX_VALUE, 255), chaos);
    }

}
