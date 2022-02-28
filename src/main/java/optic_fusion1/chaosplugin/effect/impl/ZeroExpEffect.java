package optic_fusion1.chaosplugin.effect.impl;

import optic_fusion1.chaosplugin.effect.Effect;
import org.bukkit.entity.Player;

public class ZeroExpEffect extends Effect {

    public ZeroExpEffect() {
        super("Zero Exp");
    }

    @Override
    public void activate(Player player) {
        player.setExp(0);
        player.setLevel(0);
    }

}
