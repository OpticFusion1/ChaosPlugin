package optic_fusion1.chaosplugin.effect.impl;

import optic_fusion1.chaosplugin.effect.Effect;
import optic_fusion1.chaosplugin.util.Utils;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class GiveDiamondEffect extends Effect {

  public GiveDiamondEffect() {
    super("Give Diamond");
  }

  @Override
  public void activate(Player player) {
    Utils.addItems(player, new ItemStack(Material.DIAMOND));
  }

}
