package optic_fusion1.chaosplugin.util;

import optic_fusion1.chaosplugin.ChaosPlugin;
import org.bukkit.Bukkit;
import org.bukkit.boss.BarColor;
import org.bukkit.boss.BarStyle;
import org.bukkit.boss.BossBar;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitTask;

public class BossBarCountdown {

  private BukkitTask task;
  private BossBar bossBar;
  private double duration;
  private double maxTime;
  private Runnable runnable;
  private ChaosPlugin chaos;
  private boolean killAfterRun = false;

  public BossBarCountdown(String name, double seconds, ChaosPlugin chaos) {
    this(name, seconds, chaos, false);
  }

  public BossBarCountdown(String name, double seconds, ChaosPlugin chaos, boolean killAfterRun) {
    this.duration = seconds;
    maxTime = duration;
    bossBar = Bukkit.createBossBar(name, BarColor.BLUE, BarStyle.SOLID);
    this.chaos = chaos;
    bossBar.setProgress(1.0);
    this.killAfterRun = killAfterRun;
  }

  public BossBarCountdown setRunnable(Runnable runnable) {
    this.runnable = runnable;
    return this;
  }

  public void kill() {
    task.cancel();
    bossBar.removeAll();
  }

  public void run() {
    if (task == null) {
      this.task = new BukkitRunnable() {

        @Override
        public void run() {
          if ((duration -= 1) == 0) {
            duration = maxTime;
            if (!Bukkit.getOnlinePlayers().isEmpty()) {
              runnable.run();
            }
            if (killAfterRun) {
              kill();
            }
          } else {
            bossBar.setProgress(duration / maxTime);
          }
        }
      }.runTaskTimer(chaos, 0, 1 * 20);
    }
    bossBar.setVisible(true);
  }

  public void addPlayer(Player player) {
    bossBar.addPlayer(player);
  }

  public void removePlayer(Player player) {
    bossBar.removePlayer(player);
  }

}
