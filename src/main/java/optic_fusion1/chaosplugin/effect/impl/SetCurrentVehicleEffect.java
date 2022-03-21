package optic_fusion1.chaosplugin.effect.impl;

import java.util.EnumSet;
import java.util.Random;
import optic_fusion1.chaosplugin.effect.Effect;
import optic_fusion1.chaosplugin.util.CollectionUtils;
import optic_fusion1.chaosplugin.util.Utils;
import org.bukkit.Material;
import org.bukkit.TreeSpecies;
import org.bukkit.entity.AbstractHorse;
import org.bukkit.entity.Boat;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class SetCurrentVehicleEffect extends Effect {

    private static final EnumSet<EntityType> VEHICLES = EnumSet.of(EntityType.BOAT,
            EntityType.HORSE, EntityType.LLAMA, EntityType.MINECART, EntityType.MULE, EntityType.SKELETON_HORSE,
            EntityType.STRIDER, EntityType.TRADER_LLAMA, EntityType.ZOMBIE_HORSE);

    public SetCurrentVehicleEffect() {
        super("Set Current Vehicle");
    }

    @Override
    public void activate(Player player) {
        EntityType entityType = CollectionUtils.getRandomSetElement(VEHICLES);
        Entity entity = (Entity) player.getWorld().spawnEntity(player.getLocation(), entityType);
        if (player.isInsideVehicle()) {
            player.eject();
            player.getVehicle().remove();
        }
        if (entity instanceof AbstractHorse horse) {
            horse.setDomestication(horse.getMaxDomestication());
            horse.setOwner(player);
            horse.setTamed(true);
            horse.addPassenger(player);
            horse.getInventory().setSaddle(new ItemStack(Material.SADDLE));
            return;
        }
        if (entity instanceof Boat boat) {
            Random random = new Random();
            boat.setWoodType(TreeSpecies.values()[random.nextInt(TreeSpecies.values().length)]);
            boat.addPassenger(player);
        }
    }

}
