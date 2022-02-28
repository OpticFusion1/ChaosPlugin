package optic_fusion1.chaosplugin.effect.impl;

import optic_fusion1.chaosplugin.effect.Effect;
import org.bukkit.entity.Player;

public class NiceExpEffect extends Effect {

    public NiceExpEffect() {
        super("Nice Exp");
    }

    @Override
    public void activate(Player player) {
        player.setLevel(69);
    }

}
