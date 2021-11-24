package optic_fusion1.chaosplugin.effect;

import org.bukkit.entity.Player;

public abstract class TimedEffect extends Effect {

  public TimedEffect(String name) {
    super(name);
  }

  public TimedEffect(String name, boolean isGlobal) {
    super(name, isGlobal);
  }

  public abstract void deactivate(Player player);

}
