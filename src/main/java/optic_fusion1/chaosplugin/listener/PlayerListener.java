package optic_fusion1.chaosplugin.listener;

import optic_fusion1.chaosplugin.ChaosPlugin;
import optic_fusion1.chaosplugin.util.BossBarCountdown;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class PlayerListener implements Listener {

  private BossBarCountdown effectCountdownBossBar;

  public PlayerListener(ChaosPlugin chaos) {
    effectCountdownBossBar = chaos.getEffectCountdownBossBar();
  }

  @EventHandler
  public void on(PlayerQuitEvent event) {
    Player player = event.getPlayer();
    if (player.isInvulnerable()) {
      player.setInvulnerable(false);
    }
    effectCountdownBossBar.removePlayer(player);
  }

  @EventHandler
  public void on(PlayerJoinEvent event) {
    effectCountdownBossBar.addPlayer(event.getPlayer());
  }

}
