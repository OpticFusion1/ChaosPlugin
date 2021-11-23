package optic_fusion1.chaosplugin.effect.impl;

import optic_fusion1.chaosplugin.effect.Effect;
import org.bukkit.Material;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class ButterFingersEffect extends Effect {

  public ButterFingersEffect() {
    super("ButterFingersEffect");
  }

  @Override
  public void activate(Player player) {
    ItemStack itemStack = player.getInventory().getItemInMainHand();
    if (itemStack != null && itemStack.getType() != Material.AIR) {
      Item droppedItem = player.getWorld().dropItemNaturally(player.getLocation(), itemStack);
      droppedItem.setPickupDelay(100);
    }
  }

}
