package optic_fusion1.chaosplugin.effect.impl;

import optic_fusion1.chaosplugin.effect.Effect;
import optic_fusion1.chaosplugin.util.Utils;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class StarterPackEffect extends Effect {

    public StarterPackEffect() {
        super("Starter Pack");
    }

    @Override
    public void activate(Player player) {
        ItemStack pickaxe = new ItemStack(Material.IRON_PICKAXE);
        ItemStack axe = new ItemStack(Material.IRON_AXE);
        ItemStack shovel = new ItemStack(Material.IRON_SHOVEL);
        ItemStack sword = new ItemStack(Material.IRON_SWORD);
        ItemStack bread = new ItemStack(Material.BREAD, 10);
        ItemStack torch = new ItemStack(Material.TORCH, 10);
        Utils.addItems(player, new ItemStack[]{pickaxe, axe, shovel, sword, bread, torch});
    }

}
