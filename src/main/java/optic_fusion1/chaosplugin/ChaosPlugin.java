package optic_fusion1.chaosplugin;

import optic_fusion1.chaosplugin.effect.Effect;
import optic_fusion1.chaosplugin.effect.EffectManager;
import optic_fusion1.chaosplugin.effect.impl.GiveDiamondEffect;
import optic_fusion1.chaosplugin.effect.impl.GiveDiamondItemsEffect;
import optic_fusion1.chaosplugin.effect.impl.SummonAngryBeeEffect;
import optic_fusion1.chaosplugin.effect.impl.SummonChargedCreeperEffect;
import optic_fusion1.chaosplugin.effect.impl.SummonCreeperEffect;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class ChaosPlugin extends JavaPlugin {

  private static final EffectManager EFFECT_MANAGER = new EffectManager();

  @Override
  public void onEnable() {
    registerEffects();
    registerScheduler();
  }

  @Override
  public void onDisable() {
  }

  private void registerScheduler() {
    Bukkit.getScheduler().scheduleSyncRepeatingTask(this, () -> {
      Bukkit.getOnlinePlayers().forEach(target -> {
        EFFECT_MANAGER.getRandomEffect().activate(target);
      });
    }, 600, 600);
  }

  private void registerEffects() {
    registerEffect(new GiveDiamondEffect());
    registerEffect(new GiveDiamondItemsEffect());
    registerEffect(new SummonAngryBeeEffect());
    registerEffect(new SummonCreeperEffect());
    registerEffect(new SummonChargedCreeperEffect());
  }

  private void registerEffect(Effect effect) {
    EFFECT_MANAGER.addEffect(effect);
  }

  public EffectManager getEffectManager() {
    return EFFECT_MANAGER;
  }

}
