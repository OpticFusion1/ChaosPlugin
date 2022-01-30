package optic_fusion1.chaosplugin.effect.impl;

import java.sql.Array;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;

import optic_fusion1.chaosplugin.effect.Effect;
import optic_fusion1.chaosplugin.util.Utils;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class GiveDiamondItemsEffect extends Effect {

  private static final ItemStack[] ITEMS;
  private static final EnumSet<Material> DIAMOND_MATERIALS = EnumSet.of(Material.DIAMOND_SWORD,
          Material.DIAMOND_PICKAXE, Material.DIAMOND_AXE, Material.DIAMOND_SHOVEL, Material.DIAMOND_HOE);

  static {
    List<ItemStack> itemStacks = new ArrayList<>();
    for (Material material : DIAMOND_MATERIALS) {
      itemStacks.add(new ItemStack(material));
    }
    ITEMS = itemStacks.toArray(new ItemStack[0]);
  }

  public GiveDiamondItemsEffect() {
    super("Give Diamond Items");
  }

  @Override
  public void activate(Player player) {
    Utils.addItems(player, ITEMS);
  }

}
