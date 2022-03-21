package optic_fusion1.chaosplugin.effect.impl;

import java.util.EnumSet;
import optic_fusion1.chaosplugin.effect.Effect;
import optic_fusion1.chaosplugin.util.CollectionUtils;
import optic_fusion1.chaosplugin.util.Utils;
import org.bukkit.Location;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Monster;
import org.bukkit.entity.Player;

public class SpawnRandomHostileMobEffect extends Effect {

    private static final EnumSet<EntityType> ENTITY_TYPES = EnumSet.of(EntityType.BLAZE, EntityType.CREEPER,
            EntityType.DROWNED, EntityType.ELDER_GUARDIAN, EntityType.ENDERMITE, EntityType.EVOKER, EntityType.GHAST,
            EntityType.GUARDIAN, EntityType.HOGLIN, EntityType.HUSK, EntityType.MAGMA_CUBE, EntityType.PHANTOM,
            EntityType.PIGLIN_BRUTE, EntityType.PILLAGER, EntityType.RAVAGER, EntityType.SHULKER, EntityType.SILVERFISH,
            EntityType.SKELETON, EntityType.SLIME, EntityType.STRAY, EntityType.VEX, EntityType.VINDICATOR,
            EntityType.WITCH, EntityType.WITHER_SKELETON, EntityType.ZOGLIN, EntityType.ZOMBIE,
            EntityType.ZOMBIE_VILLAGER, EntityType.ILLUSIONER);

    public SpawnRandomHostileMobEffect() {
        super("Spawn Random Hostile Mob");
    }

    @Override
    public void activate(Player player) {
        Location location = Utils.getLocationInCircle(player.getLocation(), 10);
        location.setY(location.getWorld().getHighestBlockYAt(location) + 1);
        EntityType entityType = CollectionUtils.getRandomSetElement(ENTITY_TYPES);
        Monster entity = (Monster) location.getWorld().spawnEntity(location, entityType);
        entity.setTarget(player);
    }

}
