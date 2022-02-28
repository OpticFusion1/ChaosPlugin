package optic_fusion1.chaosplugin.effect.impl;

import optic_fusion1.chaosplugin.effect.Effect;
import org.bukkit.Material;
import org.bukkit.entity.Player;

public class BedrockFeetEffect extends Effect {

    public BedrockFeetEffect() {
        super("Bedrock Feet");
    }

    @Override
    public void activate(Player player) {
        player.getLocation().subtract(0.0, 1.0, 0.0).getBlock().setType(Material.BEDROCK);
    }

}
