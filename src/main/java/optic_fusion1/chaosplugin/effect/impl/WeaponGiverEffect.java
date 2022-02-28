package optic_fusion1.chaosplugin.effect.impl;

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

public class WeaponGiverEffect extends Effect {

    private static final ItemStack[] ITEMS;
    private static final EnumSet<Material> MATERIALS = EnumSet.of(Material.WOODEN_SWORD, Material.STONE_SWORD,
            Material.GOLDEN_SWORD, Material.IRON_SWORD, Material.DIAMOND_SWORD, Material.NETHERITE_SWORD,
            Material.BOW, Material.CROSSBOW);

    static {
        List<ItemStack> itemStacks = new ArrayList<>();
        MATERIALS.forEach(material -> {
            itemStacks.add(new ItemStack(material));
        });
        itemStacks.add(new ItemStack(Material.ARROW, 64));
        itemStacks.add(new ItemStack(Material.TNT, 64));
        ITEMS = itemStacks.toArray(new ItemStack[0]);
    }

    public WeaponGiverEffect() {
        super("Weapon Giver");
    }

    @Override
    public void activate(Player player) {
        Utils.addItems(player, ITEMS);
    }

}
