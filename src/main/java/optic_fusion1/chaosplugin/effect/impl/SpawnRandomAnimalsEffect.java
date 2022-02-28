package optic_fusion1.chaosplugin.effect.impl;

import java.util.EnumSet;
import java.util.Random;
import optic_fusion1.chaosplugin.effect.Effect;
import optic_fusion1.chaosplugin.util.Utils;
import org.bukkit.DyeColor;
import org.bukkit.Location;
import org.bukkit.entity.Ageable;
import org.bukkit.entity.Axolotl;
import org.bukkit.entity.Cat;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Fox;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.MushroomCow;
import org.bukkit.entity.Player;
import org.bukkit.entity.Sheep;

public class SpawnRandomAnimalsEffect extends Effect {

    private static final EnumSet<EntityType> ENTITY_TYPES = EnumSet.of(EntityType.AXOLOTL,
            EntityType.BAT, EntityType.CAT, EntityType.CHICKEN, EntityType.COD, EntityType.COW,
            EntityType.DONKEY, EntityType.FOX, EntityType.GLOW_SQUID, EntityType.HORSE, EntityType.MUSHROOM_COW,
            EntityType.MULE, EntityType.OCELOT, EntityType.PARROT, EntityType.PIG, EntityType.PUFFERFISH,
            EntityType.RABBIT, EntityType.SALMON, EntityType.SHEEP, EntityType.SQUID, EntityType.TROPICAL_FISH,
            EntityType.TURTLE, EntityType.BEE, EntityType.DOLPHIN, EntityType.GOAT, EntityType.LLAMA,
            EntityType.PANDA, EntityType.POLAR_BEAR, EntityType.TRADER_LLAMA, EntityType.WOLF);

    public SpawnRandomAnimalsEffect() {
        super("Spawn Random Animals");
    }

    @Override
    public void activate(Player player) {
        for (int i = 0; i <= 10; i++) {
            Location location = Utils.getLocationInCircle(player.getLocation(), 10);
            location.setY(location.getWorld().getHighestBlockYAt(location) + 1);
            EntityType entityType = Utils.getRandomSetElement(ENTITY_TYPES);
            LivingEntity entity = (LivingEntity) location.getWorld().spawnEntity(location, entityType);
            if (entity instanceof Ageable ageable) {
                randomizeAge(ageable);
            }
            if (entityType == EntityType.AXOLOTL) {
                Axolotl axolotl = (Axolotl) entity;
                randomizeAxolotl(axolotl);
                continue;
            }
            if (entityType == EntityType.CAT) {
                Cat cat = (Cat) entity;
                randomizeCat(cat);
                continue;
            }

            if (entityType == EntityType.MUSHROOM_COW) {
                MushroomCow cow = (MushroomCow) entity;
                randomizeMushroomCow(cow);
                continue;
            }
            if (entityType == EntityType.FOX) {
                Fox fox = (Fox) entity;
                randomizeFox(fox);
            }
            if (entityType == EntityType.SHEEP) {
                Sheep sheep = (Sheep) entity;
                randomizeSheep(sheep);
            }
        }
    }

    private void randomizeSheep(Sheep sheep) {
        Random random = new Random();
        DyeColor color = DyeColor.values()[random.nextInt(DyeColor.values().length)];
        sheep.setColor(color);
        sheep.setSheared(random.nextInt(2) == 1);
    }

    private void randomizeFox(Fox fox) {
        Random random = new Random();
        fox.setFoxType(Fox.Type.values()[random.nextInt(Fox.Type.values().length)]);
    }

    private void randomizeMushroomCow(MushroomCow cow) {
        Random random = new Random();
        cow.setVariant(MushroomCow.Variant.values()[random.nextInt(MushroomCow.Variant.values().length)]);
    }

    private void randomizeAge(Ageable entity) {
        Random random = new Random();
        if (random.nextInt(2) == 1) {
            entity.setAdult();
        } else {
            entity.setBaby();
        }
    }

    private void randomizeCat(Cat cat) {
        Random random = new Random();
        cat.setCatType(Cat.Type.values()[random.nextInt(Cat.Type.values().length)]);
        cat.setCollarColor(DyeColor.values()[random.nextInt(DyeColor.values().length)]);
    }

    private void randomizeAxolotl(Axolotl axolotl) {
        Random random = new Random();
        if (random.nextInt(2) == 1) {
            axolotl.setPlayingDead(random.nextInt(2) == 1);
        }
        axolotl.setVariant(Axolotl.Variant.values()[random.nextInt(Axolotl.Variant.values().length)]);
    }

}
