package optic_fusion1.chaosplugin.effect.impl;

import optic_fusion1.chaosplugin.effect.Effect;
import optic_fusion1.chaosplugin.util.Utils;
import org.bukkit.entity.Player;

public class LaunchAllEntitiesEffect extends Effect {

    public LaunchAllEntitiesEffect() {
        super("Launch All Entities", true);
    }

    @Override
    public void activate(Player player) {
        player.getWorld().getLivingEntities().forEach(entity -> {
            Utils.launchEntity(entity);
        });
    }

}
