package optic_fusion1.chaosplugin.util;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.inventory.ItemStack;

public final class Utils {

  private Utils() {
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

}
