package optic_fusion1.chaosplugin.effect.impl;

import optic_fusion1.chaosplugin.effect.Effect;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class GiveDiamondEffect extends Effect {

  public GiveDiamondEffect() {
    super("Give Diamond");
  }

  @Override
  public void activate(Player player) {
    player.getInventory().addItem(new ItemStack(Material.DIAMOND));
  }

}
