package optic_fusion1.chaosplugin.effect.impl;

import optic_fusion1.chaosplugin.effect.TimedEffect;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;

public class AdventureEffect extends TimedEffect {

    public AdventureEffect() {
        super("Adventure", true);
    }

    @Override
    public void deactivate(Player player) {
        for (Player target : Bukkit.getOnlinePlayers()) {
            target.setGameMode(GameMode.SURVIVAL);
        }
    }

    @Override
    public void activate(Player player) {
        for (Player target : Bukkit.getOnlinePlayers()) {
            target.setGameMode(GameMode.ADVENTURE);
        }
    }

}
