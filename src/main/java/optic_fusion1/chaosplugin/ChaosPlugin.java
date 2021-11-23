package optic_fusion1.chaosplugin;

import java.util.concurrent.ThreadLocalRandom;
import optic_fusion1.chaosplugin.effect.Effect;
import optic_fusion1.chaosplugin.effect.EffectManager;
import optic_fusion1.chaosplugin.effect.TimedEffect;
import optic_fusion1.chaosplugin.effect.impl.AnvilEffect;
import optic_fusion1.chaosplugin.effect.impl.BedrockFeetEffect;
import optic_fusion1.chaosplugin.effect.impl.BeefEffect;
import optic_fusion1.chaosplugin.effect.impl.BlindnessEffect;
import optic_fusion1.chaosplugin.effect.impl.ButterFingersEffect;
import optic_fusion1.chaosplugin.effect.impl.ClearLagEffect;
import optic_fusion1.chaosplugin.effect.impl.FakeCreeperEffect;
import optic_fusion1.chaosplugin.effect.impl.FullHealthEffect;
import optic_fusion1.chaosplugin.effect.impl.FullHungerEffect;
import optic_fusion1.chaosplugin.effect.impl.GardenerEffect;
import optic_fusion1.chaosplugin.effect.impl.GiveDiamondEffect;
import optic_fusion1.chaosplugin.effect.impl.GiveDiamondItemsEffect;
import optic_fusion1.chaosplugin.effect.impl.HalfHeartEffect;
import optic_fusion1.chaosplugin.effect.impl.HasteEffect;
import optic_fusion1.chaosplugin.effect.impl.IgniteEffect;
import optic_fusion1.chaosplugin.effect.impl.LightningEffect;
import optic_fusion1.chaosplugin.effect.impl.MiningFatigueEffect;
import optic_fusion1.chaosplugin.effect.impl.NiceXpEffect;
import optic_fusion1.chaosplugin.effect.impl.SkyLavaEffect;
import optic_fusion1.chaosplugin.effect.impl.SkydiveEffect;
import optic_fusion1.chaosplugin.effect.impl.SpeedEffect;
import optic_fusion1.chaosplugin.effect.impl.SummonAngryBeeEffect;
import optic_fusion1.chaosplugin.effect.impl.SummonChargedCreeperEffect;
import optic_fusion1.chaosplugin.effect.impl.SummonCreeperEffect;
import optic_fusion1.chaosplugin.effect.impl.SummonTreeEffect;
import optic_fusion1.chaosplugin.effect.impl.TripEffect;
import optic_fusion1.chaosplugin.effect.impl.ZeroHungerEffect;
import optic_fusion1.chaosplugin.effect.impl.ZeroXpEffect;
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
        if(target == null){
          return;
        }
        Effect effect = EFFECT_MANAGER.getRandomEffect();
        effect.activate(target);
        if(effect instanceof TimedEffect timedEffect){
          Bukkit.getScheduler().scheduleSyncDelayedTask(this, ()->{
            timedEffect.deactivate(target);
          }, ThreadLocalRandom.current().nextInt(30, 40 + 1) * 1000);
        }
        target.sendMessage("[Chaos] " + effect.getName());
      });
    }, 600, 600);
  }

  private void registerEffects() {
    registerEffect(new GiveDiamondEffect());
    registerEffect(new GiveDiamondItemsEffect());
    registerEffect(new SummonAngryBeeEffect());
    registerEffect(new SummonCreeperEffect());
    registerEffect(new SummonChargedCreeperEffect());
    registerEffect(new ZeroXpEffect());
    registerEffect(new FakeCreeperEffect());
    registerEffect(new TripEffect());
    registerEffect(new ZeroHungerEffect());
    registerEffect(new SummonTreeEffect());
    registerEffect(new SpeedEffect());
    registerEffect(new SkyLavaEffect());
    registerEffect(new SkydiveEffect());
    registerEffect(new NiceXpEffect());
    registerEffect(new MiningFatigueEffect());
    registerEffect(new LightningEffect());
    registerEffect(new IgniteEffect());
    registerEffect(new HasteEffect());
    registerEffect(new HalfHeartEffect());
    registerEffect(new GardenerEffect());
    registerEffect(new FullHungerEffect());
    registerEffect(new FullHealthEffect());
    registerEffect(new ButterFingersEffect());
    registerEffect(new ClearLagEffect());
    registerEffect(new BlindnessEffect());
    registerEffect(new BeefEffect());
    registerEffect(new BedrockFeetEffect());
    registerEffect(new AnvilEffect());
  }

  private void registerEffect(Effect effect) {
    EFFECT_MANAGER.addEffect(effect);
  }

  public EffectManager getEffectManager() {
    return EFFECT_MANAGER;
  }

}
