package optic_fusion1.chaosplugin.effect.impl;

import optic_fusion1.chaosplugin.effect.Effect;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;

public class ClearLagEffect extends Effect {

    public ClearLagEffect() {
        super("Clear Lag", true);
    }

    @Override
    public void activate(Player player) {
        player.getWorld().getEntities().stream().filter(entity -> (entity instanceof Item)).forEachOrdered(entity -> {
            entity.remove();
        });
    }

}
