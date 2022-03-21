package optic_fusion1.chaosplugin.effect;

import optic_fusion1.chaosplugin.ChaosPlugin;
import optic_fusion1.chaosplugin.effect.impl.AdventureEffect;
import optic_fusion1.chaosplugin.effect.impl.AllPlayersExitVehicleEffect;
import optic_fusion1.chaosplugin.effect.impl.BedrockFeetEffect;
import optic_fusion1.chaosplugin.effect.impl.BeefEffect;
import optic_fusion1.chaosplugin.effect.impl.ButterFingersEffect;
import optic_fusion1.chaosplugin.effect.impl.ClearLagEffect;
import optic_fusion1.chaosplugin.effect.impl.ClearPotionEffectsEffect;
import optic_fusion1.chaosplugin.effect.impl.ComboTimeEffect;
import optic_fusion1.chaosplugin.effect.impl.DamageItemsEffect;
import optic_fusion1.chaosplugin.effect.impl.DemoScreenEffect;
import optic_fusion1.chaosplugin.effect.impl.DogLoverEffect;
import optic_fusion1.chaosplugin.effect.impl.FakeCreeperEffect;
import optic_fusion1.chaosplugin.effect.impl.FullHealthEffect;
import optic_fusion1.chaosplugin.effect.impl.FullHungerEffect;
import optic_fusion1.chaosplugin.effect.impl.GardenerEffect;
import optic_fusion1.chaosplugin.effect.impl.GiveDiamondEffect;
import optic_fusion1.chaosplugin.effect.impl.GiveDiamondItemsEffect;
import optic_fusion1.chaosplugin.effect.impl.GottaGoFastEffect;
import optic_fusion1.chaosplugin.effect.impl.HalfHeartEffect;
import optic_fusion1.chaosplugin.effect.impl.HeavenEffect;
import optic_fusion1.chaosplugin.effect.impl.HeresJohnnyEffect;
import optic_fusion1.chaosplugin.effect.impl.IgniteEffect;
import optic_fusion1.chaosplugin.effect.impl.InvisibleEntitiesEffect;
import optic_fusion1.chaosplugin.effect.impl.InvulnerableEntitiesEffect;
import optic_fusion1.chaosplugin.effect.impl.InvulnerablePlayerEffect;
import optic_fusion1.chaosplugin.effect.impl.KickEffect;
import optic_fusion1.chaosplugin.effect.impl.KillerBunnyEffect;
import optic_fusion1.chaosplugin.effect.impl.LaunchAllEntitiesEffect;
import optic_fusion1.chaosplugin.effect.impl.LaunchPlayerEffect;
import optic_fusion1.chaosplugin.effect.impl.LightningEffect;
import optic_fusion1.chaosplugin.effect.impl.MysteryEffect;
import optic_fusion1.chaosplugin.effect.impl.NiceExpEffect;
import optic_fusion1.chaosplugin.effect.impl.NothingEffect;
import optic_fusion1.chaosplugin.effect.impl.OpenRandomInventoryEffect;
import optic_fusion1.chaosplugin.effect.impl.PumpkinHatEffect;
import optic_fusion1.chaosplugin.effect.impl.SetCurrentVehicleEffect;
import optic_fusion1.chaosplugin.effect.impl.SkyLavaEffect;
import optic_fusion1.chaosplugin.effect.impl.SpawnRandomAnimalsEffect;
import optic_fusion1.chaosplugin.effect.impl.StarterPackEffect;
import optic_fusion1.chaosplugin.effect.impl.SummonAngryBeeEffect;
import optic_fusion1.chaosplugin.effect.impl.SummonChargedCreeperEffect;
import optic_fusion1.chaosplugin.effect.impl.SummonCreeperEffect;
import optic_fusion1.chaosplugin.effect.impl.SummonRandomTreeEffect;
import optic_fusion1.chaosplugin.effect.impl.TripEffect;
import optic_fusion1.chaosplugin.effect.impl.WatchOutEffect;
import optic_fusion1.chaosplugin.effect.impl.WeaponGiverEffect;
import optic_fusion1.chaosplugin.effect.impl.WhereDidEverybodyGoEffect;
import optic_fusion1.chaosplugin.effect.impl.WingManEffect;
import optic_fusion1.chaosplugin.effect.impl.ZeroExpEffect;
import optic_fusion1.chaosplugin.effect.impl.ZeroHungerEffect;
import optic_fusion1.chaosplugin.effect.impl.potioneffect.BlindnessEffect;
import optic_fusion1.chaosplugin.effect.impl.potioneffect.HasteEffect;
import optic_fusion1.chaosplugin.effect.impl.potioneffect.MiningFatigueEffect;
import optic_fusion1.chaosplugin.effect.impl.potioneffect.NightVisionEffect;
import optic_fusion1.chaosplugin.effect.impl.vampirism.VampirismEffect;
import org.bukkit.Bukkit;

public class EffectRegistery {

    private EffectManager effectManager;
    private ChaosPlugin chaos;

    public EffectRegistery(ChaosPlugin chaos) {
        this.chaos = chaos;
        effectManager = chaos.getEffectManager();
    }

    public void registerEffects() {
        registerEffect(new GiveDiamondEffect());
        registerEffect(new GiveDiamondItemsEffect());
        registerEffect(new SummonAngryBeeEffect());
        registerEffect(new SummonCreeperEffect());
        registerEffect(new SummonChargedCreeperEffect());
        registerEffect(new ZeroExpEffect());
        registerEffect(new FakeCreeperEffect());
        registerEffect(new TripEffect());
        registerEffect(new ZeroHungerEffect());
        registerEffect(new SummonRandomTreeEffect());
        registerEffect(new GottaGoFastEffect(chaos));
        registerEffect(new SkyLavaEffect());
        registerEffect(new HeavenEffect());
        registerEffect(new NiceExpEffect());
        registerEffect(new MiningFatigueEffect(chaos));
        registerEffect(new LightningEffect(chaos));
        registerEffect(new IgniteEffect());
        registerEffect(new HasteEffect(chaos));
        registerEffect(new HalfHeartEffect());
        registerEffect(new GardenerEffect());
        registerEffect(new FullHungerEffect());
        registerEffect(new FullHealthEffect());
        registerEffect(new ButterFingersEffect());
        registerEffect(new ClearLagEffect());
        registerEffect(new BlindnessEffect(chaos));
        registerEffect(new BeefEffect());
        registerEffect(new BedrockFeetEffect());
        registerEffect(new WatchOutEffect());
        registerEffect(new ComboTimeEffect(chaos));
        registerEffect(new NightVisionEffect(chaos));
        registerEffect(new NothingEffect());
        registerEffect(new WhereDidEverybodyGoEffect(chaos));
        registerEffect(new ClearPotionEffectsEffect());
        registerEffect(new LaunchPlayerEffect());
        registerEffect(new WeaponGiverEffect());
        registerEffect(new InvulnerablePlayerEffect());
        registerEffect(new SpawnRandomAnimalsEffect());
        registerEffect(new SetCurrentVehicleEffect());
        registerEffect(new KillerBunnyEffect());
        registerEffect(new HeresJohnnyEffect());
        registerEffect(new VampirismEffect(chaos));
        registerEffect(new AllPlayersExitVehicleEffect());
        registerEffect(new InvulnerableEntitiesEffect());
        registerEffect(new InvisibleEntitiesEffect());
        InvisibleEntitiesEffect invisibleEntitiesEffect = new InvisibleEntitiesEffect();
        Bukkit.getPluginManager().registerEvents(invisibleEntitiesEffect, chaos);
        registerEffect(invisibleEntitiesEffect);
        registerEffect(new LaunchAllEntitiesEffect());
        registerEffect(new DemoScreenEffect());
        registerEffect(new OpenRandomInventoryEffect());
        registerEffect(new KickEffect());
        registerEffect(new AdventureEffect());
        registerEffect(new DogLoverEffect());
        registerEffect(new WingManEffect());
        registerEffect(new StarterPackEffect());
        registerEffect(new DamageItemsEffect());
        registerEffect(new MysteryEffect(chaos));
        registerEffect(new PumpkinHatEffect());
    }

    private void registerEffect(Effect effect) {
        effectManager.addEffect(effect);
    }

}
