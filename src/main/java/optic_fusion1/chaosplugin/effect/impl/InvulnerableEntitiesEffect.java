package optic_fusion1.chaosplugin.effect.impl;

import java.util.ArrayList;
import java.util.List;
import optic_fusion1.chaosplugin.effect.TimedEffect;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;

public class InvulnerableEntitiesEffect extends TimedEffect {

    private static final List<LivingEntity> INVULNERABLE_ENTITIES = new ArrayList<>();

    public InvulnerableEntitiesEffect() {
        super("Invulnerable Entities", true);
    }

    @Override
    public void activate(Player player) {
        for (Entity entity : player.getWorld().getEntities()) {
            if (entity instanceof LivingEntity livingEntity) {
                livingEntity.setInvulnerable(true);
                INVULNERABLE_ENTITIES.add(livingEntity);
            }
        }
    }

    @Override
    public void deactivate(Player player) {
        disable();
    }

    public static void disable() {
        for (Entity entity : INVULNERABLE_ENTITIES) {
            if (entity.isInvulnerable()) {
                entity.setInvulnerable(false);
            }
        }
    }

}
