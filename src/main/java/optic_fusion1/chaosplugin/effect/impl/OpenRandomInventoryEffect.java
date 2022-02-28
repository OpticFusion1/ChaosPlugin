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
        super("Open Random Inventory");
        for (InventoryType inventoryType : InventoryType.values()) {
            try {
                INVENTORIES.add(Bukkit.createInventory(null, inventoryType));
            } catch (Exception e) {
            }
        }
    }

    @Override
    public void activate(Player player) {
        player.openInventory(INVENTORIES.get(ThreadLocalRandom.current().nextInt(INVENTORIES.size())));
    }

}
