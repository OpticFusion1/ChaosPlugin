package optic_fusion1.chaosplugin.effect.impl;

import optic_fusion1.chaosplugin.effect.Effect;
import org.bukkit.entity.Player;

public class NiceXpEffect extends Effect {

  public NiceXpEffect() {
    super("Heh. Nice.");
  }

  @Override
  public void activate(Player player) {
    player.setLevel(69);
  }

}
