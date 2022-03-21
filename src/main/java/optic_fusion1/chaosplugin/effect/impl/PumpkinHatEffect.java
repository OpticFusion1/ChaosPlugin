package optic_fusion1.chaosplugin.effect.impl;

import optic_fusion1.chaosplugin.effect.Effect;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;

public class PumpkinHatEffect extends Effect {

    public PumpkinHatEffect() {
        super("Pumpkin Hat");
    }

    @Override
    public void activate(Player player) {
        PlayerInventory playerInventory = player.getInventory();
        ItemStack helmet = playerInventory.getHelmet();
        playerInventory.setHelmet(new ItemStack(Material.PUMPKIN));
        playerInventory.addItem(helmet);
    }

}
