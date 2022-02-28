package optic_fusion1.chaosplugin.effect.impl;

import java.util.concurrent.ThreadLocalRandom;
import optic_fusion1.chaosplugin.effect.Effect;
import org.bukkit.TreeType;
import org.bukkit.entity.Player;

public class SummonRandomTreeEffect extends Effect {

    public SummonRandomTreeEffect() {
        super("Summon Random Tree");
    }

    @Override
    public void activate(Player player) {
        player.getWorld().generateTree(player.getTargetBlock(null, 10).getLocation(), TreeType.values()[ThreadLocalRandom.current().nextInt(TreeType.values().length)]);
    }

}
