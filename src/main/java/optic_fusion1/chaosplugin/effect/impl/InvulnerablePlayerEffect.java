package optic_fusion1.chaosplugin.effect.impl;

import optic_fusion1.chaosplugin.effect.TimedEffect;
import org.bukkit.entity.Player;

public class InvulnerablePlayerEffect extends TimedEffect {

    public InvulnerablePlayerEffect() {
        super("Invulnerable Player");
    }

    @Override
    public void deactivate(Player player) {
        player.setInvulnerable(false);
    }

    @Override
    public void activate(Player player) {
        player.setInvulnerable(true);
    }

}
