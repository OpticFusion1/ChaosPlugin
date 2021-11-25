package optic_fusion1.chaosplugin.effect.impl.vampirism;

import optic_fusion1.chaosplugin.ChaosPlugin;
import optic_fusion1.chaosplugin.effect.TimedEffect;
import org.bukkit.entity.Player;

public class VampirismEffect extends TimedEffect {

  private ChaosPlugin chaos;
  
  public VampirismEffect(ChaosPlugin chaos) {
    super("Vampirism");
    this.chaos = chaos;
  }

  @Override
  public void deactivate(Player player) {
    chaos.removeFromActiveVampirism(player);
  }

  @Override
  public void activate(Player player) {
    chaos.addToActiveVampirism(player);
  }

}
