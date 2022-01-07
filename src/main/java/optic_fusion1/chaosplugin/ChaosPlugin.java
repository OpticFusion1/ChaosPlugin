package optic_fusion1.chaosplugin;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import optic_fusion1.chaosplugin.effect.Effect;
import optic_fusion1.chaosplugin.effect.EffectManager;
import optic_fusion1.chaosplugin.effect.EffectRegistery;
import optic_fusion1.chaosplugin.effect.TimedEffect;
import optic_fusion1.chaosplugin.effect.impl.pacifist.PacifistListener;
import optic_fusion1.chaosplugin.effect.impl.vampirism.VampirismEffectListener;
import optic_fusion1.chaosplugin.listener.PlayerListener;
import optic_fusion1.chaosplugin.util.BossBarCountdown;
import optic_fusion1.chaosplugin.util.Utils;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class ChaosPlugin extends JavaPlugin {

  private EffectManager effectManager;
  private String prefix;
  private List<UUID> activeVampirism = new ArrayList<>();
  private List<UUID> activePacifist = new ArrayList<>();
  private BossBarCountdown effectCountdown;

  @Override
  public void onEnable() {
    loadConfig();
    effectManager = new EffectManager(this);
    new EffectRegistery(this).registerEffects();
    createEffectCountdown();
    registerListeners();
  }

  private void createEffectCountdown() {
    effectCountdown = new BossBarCountdown("Effect Countdown", getConfig().getInt("settings.next-effect-countdown"),
            this).setRunnable(() -> {
      Bukkit.getOnlinePlayers().forEach(target -> {
        runRandomEffect(target);
      });
    });
    effectCountdown.run();
  }

  private void registerListeners() {
    PluginManager pluginManager = Bukkit.getPluginManager();
    pluginManager.registerEvents(new PlayerListener(this), this);
    pluginManager.registerEvents(new VampirismEffectListener(this), this);
    pluginManager.registerEvents(new PacifistListener(this), this);
  }

  private void loadConfig() {
    File configFile = new File(getDataFolder(), "config.yml");
    if (!configFile.exists()) {
      saveDefaultConfig();
    }
    FileConfiguration config = getConfig();
    prefix = Utils.colorize(config.getString("settings.prefix"));
  }

  public void runRandomEffect(Player target) {
    runRandomEffect(target, false);
  }

  public void runRandomEffect(Player target, boolean mysteryEffect) {
    if (target == null) {
      return;
    }
    Effect effect = effectManager.getRandomEnabledEffect().get();
    effect.activate(target);
    if (effect instanceof TimedEffect timedEffect) {
      BossBarCountdown countdown = new BossBarCountdown(mysteryEffect ? "Mystery Effect" : effect.getName(),
              getConfig().getInt("settings.effect-countdown"), this, true).setRunnable(() -> {
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
    if (!mysteryEffect) {
      Bukkit.getScheduler().scheduleSyncDelayedTask(this, () -> {
        target.sendMessage(Utils.colorize(prefix + effect.getName()));
      }, 1);
    }
  }

  public EffectManager getEffectManager() {
    return effectManager;
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
