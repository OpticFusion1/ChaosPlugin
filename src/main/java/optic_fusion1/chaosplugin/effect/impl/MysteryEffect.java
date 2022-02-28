package optic_fusion1.chaosplugin.effect.impl;

import optic_fusion1.chaosplugin.ChaosPlugin;
import optic_fusion1.chaosplugin.effect.Effect;
import org.bukkit.entity.Player;

public class MysteryEffect extends Effect {

    private ChaosPlugin chaos;

    public MysteryEffect(ChaosPlugin chaos) {
        super("Mystery Effect");
        this.chaos = chaos;
    }

    @Override
    public void activate(Player player) {
        chaos.runRandomEffect(player, true);
    }

}
