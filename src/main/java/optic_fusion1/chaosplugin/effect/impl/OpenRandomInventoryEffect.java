package optic_fusion1.chaosplugin.effect.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import optic_fusion1.chaosplugin.effect.Effect;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;

public class OpenRandomInventoryEffect extends Effect {

  private static final List<Inventory> INVENTORIES = new ArrayList<>();

  public OpenRandomInventoryEffect() {
    super("OpenRandomInventory");
    for (InventoryType inventoryType : InventoryType.values()) {
      INVENTORIES.add(Bukkit.createInventory(null, inventoryType));
    }
  }

  @Override
  public void activate(Player player) {
    player.openInventory(INVENTORIES.get(ThreadLocalRandom.current().nextInt(INVENTORIES.size())));
  }

}
