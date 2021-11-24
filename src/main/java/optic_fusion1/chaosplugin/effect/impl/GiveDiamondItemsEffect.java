package optic_fusion1.chaosplugin.effect.impl;

import java.util.EnumSet;
import optic_fusion1.chaosplugin.effect.Effect;
import optic_fusion1.chaosplugin.util.Utils;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;

public class GiveDiamondItemsEffect extends Effect {

  public GiveDiamondItemsEffect() {
    super("Give Diamond Items");
  }

  private static final EnumSet<Material> DIAMOND_MATERIALS = EnumSet.of(Material.DIAMOND_SWORD,
          Material.DIAMOND_PICKAXE, Material.DIAMOND_AXE, Material.DIAMOND_SHOVEL, Material.DIAMOND_HOE);

  @Override
  public void activate(Player player) {
    Location location = player.getLocation();
    for (Material material : DIAMOND_MATERIALS) {
      Utils.dropItemNaturally(location, material);
    }
  }

}
