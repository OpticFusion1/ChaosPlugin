package optic_fusion1.chaosplugin;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;
import optic_fusion1.chaosplugin.effect.Effect;
import optic_fusion1.chaosplugin.effect.EffectManager;
import optic_fusion1.chaosplugin.effect.TimedEffect;
import optic_fusion1.chaosplugin.effect.impl.AdditionalEffectsEffect;
import optic_fusion1.chaosplugin.effect.impl.AllPlayersExitVehicleEffect;
import optic_fusion1.chaosplugin.effect.impl.AloneEffect;
import optic_fusion1.chaosplugin.effect.impl.AnvilEffect;
import optic_fusion1.chaosplugin.effect.impl.BedrockFeetEffect;
import optic_fusion1.chaosplugin.effect.impl.BeefEffect;
import optic_fusion1.chaosplugin.effect.impl.BlindnessEffect;
import optic_fusion1.chaosplugin.effect.impl.ButterFingersEffect;
import optic_fusion1.chaosplugin.effect.impl.ClearEffectsEffect;
import optic_fusion1.chaosplugin.effect.impl.ClearLagEffect;
import optic_fusion1.chaosplugin.effect.impl.FakeCreeperEffect;
import optic_fusion1.chaosplugin.effect.impl.FullHealthEffect;
import optic_fusion1.chaosplugin.effect.impl.FullHungerEffect;
import optic_fusion1.chaosplugin.effect.impl.GardenerEffect;
import optic_fusion1.chaosplugin.effect.impl.GiveDiamondEffect;
import optic_fusion1.chaosplugin.effect.impl.GiveDiamondItemsEffect;
import optic_fusion1.chaosplugin.effect.impl.HalfHeartEffect;
import optic_fusion1.chaosplugin.effect.impl.HasteEffect;
import optic_fusion1.chaosplugin.effect.impl.HeresJohnnyEffect;
import optic_fusion1.chaosplugin.effect.impl.IgniteEffect;
import optic_fusion1.chaosplugin.effect.impl.InvisibleEntitiesEffect;
import optic_fusion1.chaosplugin.effect.impl.InvulnerableEntitiesEffect;
import optic_fusion1.chaosplugin.effect.impl.InvulnerablePlayerEffect;
import optic_fusion1.chaosplugin.effect.impl.KillerBunnyEffect;
import optic_fusion1.chaosplugin.effect.impl.LaunchPlayerEffect;
import optic_fusion1.chaosplugin.effect.impl.LightningEffect;
import optic_fusion1.chaosplugin.effect.impl.MiningFatigueEffect;
import optic_fusion1.chaosplugin.effect.impl.NiceXpEffect;
import optic_fusion1.chaosplugin.effect.impl.NightVisionEffect;
import optic_fusion1.chaosplugin.effect.impl.NothingEffect;
import optic_fusion1.chaosplugin.effect.impl.SetCurrentVehicleEffect;
import optic_fusion1.chaosplugin.effect.impl.SkyLavaEffect;
import optic_fusion1.chaosplugin.effect.impl.SkydiveEffect;
import optic_fusion1.chaosplugin.effect.impl.SpawnRandomAnimalsEffect;
import optic_fusion1.chaosplugin.effect.impl.SpeedEffect;
import optic_fusion1.chaosplugin.effect.impl.SummonAngryBeeEffect;
import optic_fusion1.chaosplugin.effect.impl.SummonChargedCreeperEffect;
import optic_fusion1.chaosplugin.effect.impl.SummonCreeperEffect;
import optic_fusion1.chaosplugin.effect.impl.SummonRandomTreeEffect;
import optic_fusion1.chaosplugin.effect.impl.TripEffect;
import optic_fusion1.chaosplugin.effect.impl.WeaponGiverEffect;
import optic_fusion1.chaosplugin.effect.impl.ZeroHungerEffect;
import optic_fusion1.chaosplugin.effect.impl.ZeroXpEffect;
import optic_fusion1.chaosplugin.effect.impl.pacifist.PacifistListener;
import optic_fusion1.chaosplugin.effect.impl.vampirism.VampirismEffect;
import optic_fusion1.chaosplugin.effect.impl.vampirism.VampirismEffectListener;
import optic_fusion1.chaosplugin.listener.PlayerListener;
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

  @Override
  public void onEnable() {
    loadConfig();
    effectManager = new EffectManager(this);
    registerEffects();
    registerScheduler();
    registerListeners();
  }

  @Override
  public void onDisable() {
  }

  private void registerListeners() {
    PluginManager pluginManager = Bukkit.getPluginManager();
    pluginManager.registerEvents(new PlayerListener(), this);
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

  private void registerScheduler() {
    Bukkit.getScheduler().scheduleSyncRepeatingTask(this, () -> {
      Bukkit.getOnlinePlayers().forEach(target -> {
        runRandomEffect(target);
      });
    }, 600, 600);
  }

  public void runRandomEffect(Player target) {
    if (target == null) {
      return;
    }
    Effect effect = effectManager.getRandomEnabledEffect().get();
    effect.activate(target);
    if (effect instanceof TimedEffect timedEffect) {
      Bukkit.getScheduler().scheduleSyncDelayedTask(this, () -> {
        String message = Utils.colorize(prefix + effect.getName());
        if (effect.isGlobal()) {
          Bukkit.broadcastMessage(message);
          return;
        }
        target.sendMessage(message);
        timedEffect.deactivate(target);
      }, ThreadLocalRandom.current().nextInt(30, 40 + 1) * 20);
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
    registerEffect(new ZeroXpEffect());
    registerEffect(new FakeCreeperEffect());
    registerEffect(new TripEffect());
    registerEffect(new ZeroHungerEffect());
    registerEffect(new SummonRandomTreeEffect());
    registerEffect(new SpeedEffect());
    registerEffect(new SkyLavaEffect());
    registerEffect(new SkydiveEffect());
    registerEffect(new NiceXpEffect());
    registerEffect(new MiningFatigueEffect());
    registerEffect(new LightningEffect(this));
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
    registerEffect(new AdditionalEffectsEffect(this));
    registerEffect(new NightVisionEffect());
    registerEffect(new NothingEffect());
    registerEffect(new AloneEffect(this));
    registerEffect(new ClearEffectsEffect());
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

}
