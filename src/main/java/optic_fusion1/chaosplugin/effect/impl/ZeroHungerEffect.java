package optic_fusion1.chaosplugin.effect.impl;

import optic_fusion1.chaosplugin.effect.Effect;
import org.bukkit.entity.Player;

public class ZeroHungerEffect extends Effect {

    public ZeroHungerEffect() {
        super("Zero Hunger");
    }

    @Override
    public void activate(Player player) {
        player.setFoodLevel(0);
    }

}
