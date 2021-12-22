package optic_fusion1.chaosplugin;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import optic_fusion1.chaosplugin.effect.Effect;
import optic_fusion1.chaosplugin.effect.EffectManager;
import optic_fusion1.chaosplugin.effect.TimedEffect;
import optic_fusion1.chaosplugin.effect.impl.ComboTimeEffect;
import optic_fusion1.chaosplugin.effect.impl.AllPlayersExitVehicleEffect;
import optic_fusion1.chaosplugin.effect.impl.WhereDidEverybodyGoEffect;
import optic_fusion1.chaosplugin.effect.impl.WatchOutEffect;
import optic_fusion1.chaosplugin.effect.impl.BedrockFeetEffect;
import optic_fusion1.chaosplugin.effect.impl.BeefEffect;
import optic_fusion1.chaosplugin.effect.impl.ButterFingersEffect;
import optic_fusion1.chaosplugin.effect.impl.ClearPotionEffectsEffect;
import optic_fusion1.chaosplugin.effect.impl.ClearLagEffect;
import optic_fusion1.chaosplugin.effect.impl.DemoScreenEffect;
import optic_fusion1.chaosplugin.effect.impl.FakeCreeperEffect;
import optic_fusion1.chaosplugin.effect.impl.FullHealthEffect;
import optic_fusion1.chaosplugin.effect.impl.FullHungerEffect;
import optic_fusion1.chaosplugin.effect.impl.GardenerEffect;
import optic_fusion1.chaosplugin.effect.impl.GiveDiamondEffect;
import optic_fusion1.chaosplugin.effect.impl.GiveDiamondItemsEffect;
import optic_fusion1.chaosplugin.effect.impl.HalfHeartEffect;
import optic_fusion1.chaosplugin.effect.impl.HeresJohnnyEffect;
import optic_fusion1.chaosplugin.effect.impl.IgniteEffect;
import optic_fusion1.chaosplugin.effect.impl.InvisibleEntitiesEffect;
import optic_fusion1.chaosplugin.effect.impl.InvulnerableEntitiesEffect;
import optic_fusion1.chaosplugin.effect.impl.InvulnerablePlayerEffect;
import optic_fusion1.chaosplugin.effect.impl.KillerBunnyEffect;
import optic_fusion1.chaosplugin.effect.impl.LaunchPlayerEffect;
import optic_fusion1.chaosplugin.effect.impl.LightningEffect;
import optic_fusion1.chaosplugin.effect.impl.NiceExpEffect;
import optic_fusion1.chaosplugin.effect.impl.NothingEffect;
import optic_fusion1.chaosplugin.effect.impl.SetCurrentVehicleEffect;
import optic_fusion1.chaosplugin.effect.impl.SkyLavaEffect;
import optic_fusion1.chaosplugin.effect.impl.HeavenEffect;
import optic_fusion1.chaosplugin.effect.impl.SpawnRandomAnimalsEffect;
import optic_fusion1.chaosplugin.effect.impl.GottaGoFastEffect;
import optic_fusion1.chaosplugin.effect.impl.KickEffect;
import optic_fusion1.chaosplugin.effect.impl.LaunchAllEntitiesEffect;
import optic_fusion1.chaosplugin.effect.impl.OpenRandomInventoryEffect;
import optic_fusion1.chaosplugin.effect.impl.SummonAngryBeeEffect;
import optic_fusion1.chaosplugin.effect.impl.SummonChargedCreeperEffect;
import optic_fusion1.chaosplugin.effect.impl.SummonCreeperEffect;
import optic_fusion1.chaosplugin.effect.impl.SummonRandomTreeEffect;
import optic_fusion1.chaosplugin.effect.impl.TripEffect;
import optic_fusion1.chaosplugin.effect.impl.WeaponGiverEffect;
import optic_fusion1.chaosplugin.effect.impl.ZeroHungerEffect;
import optic_fusion1.chaosplugin.effect.impl.ZeroExpEffect;
import optic_fusion1.chaosplugin.effect.impl.pacifist.PacifistListener;
import optic_fusion1.chaosplugin.effect.impl.potioneffect.BlindnessEffect;
import optic_fusion1.chaosplugin.effect.impl.potioneffect.HasteEffect;
import optic_fusion1.chaosplugin.effect.impl.potioneffect.MiningFatigueEffect;
import optic_fusion1.chaosplugin.effect.impl.potioneffect.NightVisionEffect;
import optic_fusion1.chaosplugin.effect.impl.vampirism.VampirismEffect;
import optic_fusion1.chaosplugin.effect.impl.vampirism.VampirismEffectListener;
import optic_fusion1.chaosplugin.listener.PlayerListener;
import optic_fusion1.chaosplugin.util.BossBarCountdown;
import optic_fusion1.chaosplugin.util.Utils;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class ChaosPlugin extends JavaPlugin {

  private EffectManager effectManager;
  private FileConfiguration config;
  private String prefix;
  private List<UUID> activeVampirism = new ArrayList<>();
  private List<UUID> activePacifist = new ArrayList<>();
  private InvisibleEntitiesEffect invisibleEntitiesEffect = new InvisibleEntitiesEffect();
  private BossBarCountdown effectCountdown = new BossBarCountdown("Effect Countdown", 30, this).setRunnable(() -> {
    Bukkit.getOnlinePlayers().forEach(target -> {
      runRandomEffect(target);
    });
  });

  @Override
  public void onEnable() {
    loadConfig();
    effectManager = new EffectManager(this);
    registerEffects();
    registerListeners();
    effectCountdown.run();
  }

  @Override
  public void onDisable() {
  }

  private void registerListeners() {
    PluginManager pluginManager = Bukkit.getPluginManager();
    pluginManager.registerEvents(new PlayerListener(this), this);
    pluginManager.registerEvents(new VampirismEffectListener(this), this);
    pluginManager.registerEvents(new PacifistListener(this), this);
    pluginManager.registerEvents(invisibleEntitiesEffect, this);
  }

  private void loadConfig() {
    if (!getDataFolder().exists()) {
      getDataFolder().mkdirs();
    }
    File configFile = new File(getDataFolder(), "config.yml");
    if (!configFile.exists()) {
      saveDefaultConfig();
    }
    config = YamlConfiguration.loadConfiguration(configFile);
    prefix = config.getString("prefix");
  }

  public void runRandomEffect(Player target) {
    if (target == null) {
      return;
    }
    Effect effect = effectManager.getRandomEnabledEffect().get();
    effect.activate(target);
    if (effect instanceof TimedEffect timedEffect) {
      BossBarCountdown countdown = new BossBarCountdown(effect.getName(), 90, this, true).setRunnable(() -> {
        timedEffect.deactivate(target);
      });

      if (timedEffect.isGlobal()) {
        for (Player player : Bukkit.getOnlinePlayers()) {
          countdown.addPlayer(player);
        }
        countdown.run();
        return;
      }
      countdown.addPlayer(target);
      countdown.run();
      return;
    }

    Bukkit.getScheduler().scheduleSyncDelayedTask(this, () -> {
      target.sendMessage(Utils.colorize(prefix + effect.getName()));
    }, 1);
  }

  private void registerEffects() {
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
    registerEffect(new GottaGoFastEffect());
    registerEffect(new SkyLavaEffect());
    registerEffect(new HeavenEffect());
    registerEffect(new NiceExpEffect());
    registerEffect(new MiningFatigueEffect(this));
    registerEffect(new LightningEffect(this));
    registerEffect(new IgniteEffect());
    registerEffect(new HasteEffect(this));
    registerEffect(new HalfHeartEffect());
    registerEffect(new GardenerEffect());
    registerEffect(new FullHungerEffect());
    registerEffect(new FullHealthEffect());
    registerEffect(new ButterFingersEffect());
    registerEffect(new ClearLagEffect());
    registerEffect(new BlindnessEffect(this));
    registerEffect(new BeefEffect());
    registerEffect(new BedrockFeetEffect());
    registerEffect(new WatchOutEffect());
    registerEffect(new ComboTimeEffect(this));
    registerEffect(new NightVisionEffect(this));
    registerEffect(new NothingEffect());
    registerEffect(new WhereDidEverybodyGoEffect(this));
    registerEffect(new ClearPotionEffectsEffect());
    registerEffect(new LaunchPlayerEffect());
    registerEffect(new WeaponGiverEffect());
    registerEffect(new InvulnerablePlayerEffect());
    registerEffect(new SpawnRandomAnimalsEffect());
    registerEffect(new SetCurrentVehicleEffect());
    registerEffect(new KillerBunnyEffect());
    registerEffect(new HeresJohnnyEffect());
    registerEffect(new VampirismEffect(this));
    registerEffect(new AllPlayersExitVehicleEffect());
    registerEffect(new InvulnerableEntitiesEffect());
    registerEffect(new InvisibleEntitiesEffect());
    registerEffect(invisibleEntitiesEffect);
    registerEffect(new LaunchAllEntitiesEffect());
    registerEffect(new DemoScreenEffect());
    registerEffect(new OpenRandomInventoryEffect());
    registerEffect(new KickEffect());
  }

  private void registerEffect(Effect effect) {
    effectManager.addEffect(effect);
  }

  public EffectManager getEffectManager() {
    return effectManager;
  }

  @Override
  public FileConfiguration getConfig() {
    return config;
  }

  public void addToActiveVampirism(Player player) {
    activeVampirism.add(player.getUniqueId());
  }

  public void removeFromActiveVampirism(Player player) {
    activeVampirism.remove(player.getUniqueId());
  }

  public boolean isVampirismEffectEnabledForPlayer(Player player) {
    return activeVampirism.contains(player.getUniqueId());
  }

  public void addToActivePacifist(Player player) {
    activePacifist.add(player.getUniqueId());
  }

  public void removeFromActivePacifist(Player player) {
    activePacifist.remove(player.getUniqueId());
  }

  public boolean isPacifistEffectEnabledForPlayer(Player player) {
    return activePacifist.contains(player.getUniqueId());
  }

  public BossBarCountdown getEffectCountdownBossBar() {
    return effectCountdown;
  }

}
