package optic_fusion1.chaosplugin.effect.impl;

import optic_fusion1.chaosplugin.effect.Effect;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class TripEffect extends Effect {

  public TripEffect() {
    super("TripEffect");
  }

  @Override
  public void activate(Player player) {
    for (ItemStack itemStack : player.getInventory().getContents()) {
      if (itemStack != null) {
        Item droppedItem = player.getWorld().dropItemNaturally(player.getLocation(), itemStack);
        player.getInventory().remove(itemStack);
        droppedItem.setPickupDelay(100);
      }
    }
  }

}
