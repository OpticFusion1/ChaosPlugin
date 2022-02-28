package optic_fusion1.chaosplugin.effect.impl;

import optic_fusion1.chaosplugin.effect.Effect;
import optic_fusion1.chaosplugin.util.Utils;
import org.bukkit.Location;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.entity.Rabbit;

public class KillerBunnyEffect extends Effect {

    public KillerBunnyEffect() {
        super("Killer Bunny");
    }

    @Override
    public void activate(Player player) {
        Location location = Utils.getLocationInCircle(player.getLocation(), 10);
        location.setY(location.getWorld().getHighestBlockYAt(location) + 1);
        Rabbit rabbit = (Rabbit) player.getWorld().spawnEntity(location, EntityType.RABBIT);
        rabbit.setRabbitType(Rabbit.Type.THE_KILLER_BUNNY);
        rabbit.setTarget(player);
    }

}
