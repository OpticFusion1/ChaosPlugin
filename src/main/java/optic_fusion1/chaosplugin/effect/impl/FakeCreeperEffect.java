package optic_fusion1.chaosplugin.effect.impl;

import optic_fusion1.chaosplugin.effect.Effect;
import optic_fusion1.chaosplugin.util.SoundUtils;
import org.bukkit.Sound;
import org.bukkit.entity.Player;

public class FakeCreeperEffect extends Effect {

    public FakeCreeperEffect() {
        super("Fake Creeper");
    }

    @Override
    public void activate(Player player) {
        SoundUtils.playForPlayer(player, Sound.ENTITY_CREEPER_PRIMED);
    }

}
