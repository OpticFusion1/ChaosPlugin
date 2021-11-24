package optic_fusion1.chaosplugin.listener;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class PlayerListener implements Listener {

  @EventHandler
  public void on(PlayerQuitEvent event) {
    Player player = event.getPlayer();
    if (player.isInvulnerable()) {
      player.setInvulnerable(false);
    }
  }

}
