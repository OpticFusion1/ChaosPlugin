package optic_fusion1.chaosplugin.util;

import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.entity.Player;

public final class SoundUtils {

  private SoundUtils() {
  }

  public static void playForAllPlayers(Sound sound) {
    playForAllPlayers(sound, 1.0f, 1.0f);
  }

  public static void playForAllPlayers(Sound sound, float volume, float pitch) {
    for (Player player : Bukkit.getOnlinePlayers()) {
      playForPlayer(player, sound, volume, pitch);
    }
  }

  public static void playForPlayer(Player player, Sound sound) {
    player.getWorld().playSound(player.getLocation(), sound, 1.0f, 1.0f);
  }

  public static void playForPlayer(Player player, Sound sound, float volume, float pitch) {
    player.getWorld().playSound(player.getLocation(), sound, volume, pitch);
  }

}
