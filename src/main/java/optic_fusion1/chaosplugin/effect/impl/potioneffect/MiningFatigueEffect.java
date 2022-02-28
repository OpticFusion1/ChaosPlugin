package optic_fusion1.chaosplugin.effect.impl.potioneffect;

import optic_fusion1.chaosplugin.ChaosPlugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class MiningFatigueEffect extends PotionEffectEffect {

    public MiningFatigueEffect(ChaosPlugin chaos) {
        super("Mining Fatigue", new PotionEffect(PotionEffectType.SLOW_DIGGING, Integer.MAX_VALUE, 255), chaos);
    }

}
