package optic_fusion1.chaosplugin.effect.impl;

import optic_fusion1.chaosplugin.ChaosPlugin;
import optic_fusion1.chaosplugin.effect.Effect;
import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.entity.Player;

public class LightningEffect extends Effect {

    private ChaosPlugin chaos;

    public LightningEffect(ChaosPlugin plugin) {
        super("Lightning");
        this.chaos = plugin;
    }

    @Override
    public void activate(Player player) {
        World world = player.getWorld();
        world.playSound(player.getLocation(), Sound.ENTITY_LIGHTNING_BOLT_THUNDER, 1.0f, 1.0f);
        world.strikeLightning(player.getLocation());
        Bukkit.getScheduler().scheduleSyncDelayedTask(chaos, () -> {
            world.playSound(player.getLocation(), Sound.ENTITY_LIGHTNING_BOLT_IMPACT, 1.0f, 1.0f);
        }, 1);
    }

}
