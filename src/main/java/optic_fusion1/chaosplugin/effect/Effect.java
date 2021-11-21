package optic_fusion1.chaosplugin.effect;

import org.bukkit.entity.Player;

public abstract class Effect {

  private String name;

  public Effect(String name) {
    this.name = name;
  }
  
  public abstract void activate(Player player);

  public String getName() {
    return name;
  }

}
