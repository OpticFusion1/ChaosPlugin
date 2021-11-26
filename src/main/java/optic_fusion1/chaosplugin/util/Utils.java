package optic_fusion1.chaosplugin.util;

import static java.lang.Math.random;
import java.util.Collection;
import java.util.Optional;
import java.util.Random;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.entity.Entity;
import org.bukkit.inventory.ItemStack;
import org.bukkit.util.Vector;

public final class Utils {

  private static int SERVER_VERSION = -1;

  private Utils() {
  }

  public static int getVersion() {
    if (SERVER_VERSION != -1) {
      return SERVER_VERSION;
    }
    SERVER_VERSION = Integer.parseInt(Bukkit.getServer().getClass().getPackage().getName().replace(".", ",").split(",")[3]
            .replace("1_", "").replaceAll("_R\\d", "").replaceAll("v", ""));
    return SERVER_VERSION;
  }

  public static String colorize(String string) {
    if (getVersion() >= 16) {
      Pattern pattern = Pattern.compile("#[a-fA-F0-9]{6}");
      for (Matcher matcher = pattern.matcher(string); matcher.find(); matcher = pattern.matcher(string)) {
        String color = string.substring(matcher.start(), matcher.end());
        string = string.replace(color, net.md_5.bungee.api.ChatColor.of(color) + "");
      }
      string = ChatColor.translateAlternateColorCodes('&', string);
      return string;
    }
    return ChatColor.translateAlternateColorCodes('&', string);
  }

  public static void dropItemNaturally(Location location, Material material) {
    location.getWorld().dropItemNaturally(location, new ItemStack(material));
  }

  public static void dropItemNaturally(Location location, ItemStack... itemStacks) {
    World world = location.getWorld();
    for (ItemStack itemStack : itemStacks) {
      world.dropItemNaturally(location, itemStack);
    }
  }

  public static <E> Optional<E> getRandomCollectionElement(Collection<E> e) {
    return e.stream().skip((int) (e.size() * Math.random())).findFirst();
  }

  public static <E> E getRandomSetElement(Set<E> set) {
    return set.stream().skip(new Random().nextInt(set.size())).findFirst().orElse(null);
  }

  public static Location getLocationInCircle(Location origin, Integer radius) {
    double angle = random() * 360;
    return origin.add(Math.cos(angle) * radius, 0, Math.sin(angle) * radius);
  }

  public static void launchEntity(Entity entity) {
    Location location = entity.getLocation();
    location.setPitch(-90);
    entity.teleport(location);
    Vector direction = location.getDirection();
    entity.setVelocity(direction.multiply(50.0));
  }

}
