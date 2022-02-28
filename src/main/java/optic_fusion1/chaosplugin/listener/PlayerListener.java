package optic_fusion1.chaosplugin.listener;

import optic_fusion1.chaosplugin.ChaosPlugin;
import optic_fusion1.chaosplugin.user.User;
import optic_fusion1.chaosplugin.user.UserManager;
import optic_fusion1.chaosplugin.util.BossBarCountdown;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class PlayerListener implements Listener {

    private BossBarCountdown effectCountdownBossBar;
    private UserManager userManager;

    public PlayerListener(ChaosPlugin chaos) {
        effectCountdownBossBar = chaos.getEffectCountdownBossBar();
        userManager = chaos.getUserManager();
    }

    @EventHandler
    public void on(PlayerQuitEvent event) {
        Player player = event.getPlayer();
        if (player.isInvulnerable()) {
            player.setInvulnerable(false);
        }
        if (player.isInvisible()) {
            player.setInvisible(false);
        }
        effectCountdownBossBar.removePlayer(player);
        userManager.removeUSer(player.getUniqueId());
    }

    @EventHandler
    public void on(PlayerJoinEvent event) {
        userManager.addUser(new User(event.getPlayer().getUniqueId()));
        effectCountdownBossBar.addPlayer(event.getPlayer());
    }

}
