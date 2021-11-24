package optic_fusion1.chaosplugin.effect.impl;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;
import optic_fusion1.chaosplugin.effect.Effect;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class WeaponGiverEffect extends Effect {

  private static final List<ItemStack> ITEMS = new ArrayList<>();
  private static final EnumSet<Material> MATERIALS = EnumSet.of(Material.WOODEN_SWORD, Material.STONE_SWORD,
          Material.GOLDEN_SWORD, Material.IRON_SWORD, Material.DIAMOND_SWORD, Material.NETHERITE_SWORD,
          Material.BOW, Material.CROSSBOW);

  static {
    MATERIALS.forEach(material -> {
      ITEMS.add(new ItemStack(material));
    });
    ITEMS.add(new ItemStack(Material.ARROW, 64));
    ITEMS.add(new ItemStack(Material.TNT, 64));
  }

  public WeaponGiverEffect() {
    super("Weapon Giver");
  }

  @Override
  public void activate(Player player) {
    Location location = player.getLocation();
    World world = location.getWorld();
    for (ItemStack itemStack : ITEMS) {
      world.dropItemNaturally(location, itemStack);
    }
  }

}
