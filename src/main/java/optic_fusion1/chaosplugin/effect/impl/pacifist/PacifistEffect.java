package optic_fusion1.chaosplugin.effect.impl.pacifist;

import optic_fusion1.chaosplugin.ChaosPlugin;
import optic_fusion1.chaosplugin.effect.TimedEffect;
import org.bukkit.entity.Player;

public class PacifistEffect extends TimedEffect {

    private ChaosPlugin chaos;

    public PacifistEffect(ChaosPlugin chaos) {
        super("Pacifist");
        this.chaos = chaos;
    }

    @Override
    public void deactivate(Player player) {
        chaos.removeFromActivePacifist(player);
    }

    @Override
    public void activate(Player player) {
        chaos.addToActivePacifist(player);
    }

}
