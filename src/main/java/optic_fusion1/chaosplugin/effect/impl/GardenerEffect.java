package optic_fusion1.chaosplugin.effect.impl;

import java.sql.Array;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;
import optic_fusion1.chaosplugin.effect.Effect;
import optic_fusion1.chaosplugin.util.Utils;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class GardenerEffect extends Effect {

  private static final ItemStack[] ITEMS;
  private static final EnumSet<Material> MATERIALS = EnumSet.of(Material.OAK_SAPLING, Material.SPRUCE_SAPLING,
          Material.BIRCH_SAPLING, Material.JUNGLE_SAPLING, Material.ACACIA_SAPLING, Material.DARK_OAK_SAPLING,
          Material.GRASS, Material.FERN, Material.DEAD_BUSH, Material.SEAGRASS, Material.SEA_PICKLE,
          Material.DANDELION, Material.POPPY, Material.BLUE_ORCHID, Material.ALLIUM, Material.AZURE_BLUET,
          Material.ORANGE_TULIP, Material.WHITE_TULIP, Material.PINK_TULIP, Material.OXEYE_DAISY,
          Material.CORNFLOWER, Material.LILY_OF_THE_VALLEY, Material.WITHER_ROSE, Material.BROWN_MUSHROOM,
          Material.RED_MUSHROOM, Material.CRIMSON_FUNGUS, Material.WARPED_FUNGUS, Material.CRIMSON_ROOTS,
          Material.WARPED_ROOTS, Material.NETHER_SPROUTS, Material.WEEPING_VINES, Material.TWISTING_VINES,
          Material.SUGAR_CANE, Material.KELP, Material.BAMBOO, Material.VINE, Material.LILY_PAD, Material.LILAC,
          Material.ROSE_BUSH, Material.PEONY, Material.TALL_GRASS, Material.LARGE_FERN, Material.SWEET_BERRIES);

  static {
    List<ItemStack> itemStacks = new ArrayList<>();
    MATERIALS.forEach(material -> {
      itemStacks.add(createItem(material));
    });
    ITEMS = itemStacks.toArray(new ItemStack[0]);
  }

  public GardenerEffect() {
    super("Gardener");
  }

  @Override
  public void activate(Player player) {
    Utils.addItems(player, ITEMS);
  }

  private static ItemStack createItem(Material material) {
    return new ItemStack(material, 16);
  }

}
