package optic_fusion1.chaosplugin.effect.impl;

import optic_fusion1.chaosplugin.effect.Effect;
import org.bukkit.entity.Player;

public class FullHungerEffect extends Effect {

    public FullHungerEffect() {
        super("Full Hunger");
    }

    @Override
    public void activate(Player player) {
        player.setFoodLevel(20);
        player.setSaturation(20.0f);
    }

}
