package optic_fusion1.chaosplugin.effect.impl;

import optic_fusion1.chaosplugin.effect.Effect;
import optic_fusion1.chaosplugin.util.Utils;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.entity.Bee;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;

public class SummonAngryBeeEffect extends Effect {

    public SummonAngryBeeEffect() {
        super("Summon Angry Bee");
    }

    @Override
    public void activate(Player player) {
        Location location = Utils.getLocationInCircle(player.getLocation(), 10);
        location.setY(location.getWorld().getHighestBlockYAt(location) + 1);
        Bee bee = (Bee) location.getWorld().spawnEntity(location, EntityType.BEE);
        bee.setCustomName(ChatColor.RED + "Angry Bee");
        bee.setCustomNameVisible(true);
        bee.setAnger(100000);
        bee.setTarget(player);
    }

}
