package optic_fusion1.chaosplugin.effect.impl;

import java.util.concurrent.ThreadLocalRandom;
import optic_fusion1.chaosplugin.effect.Effect;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.meta.Damageable;

public class DamageItemsEffect extends Effect {

  public DamageItemsEffect() {
    super("Damage Items");
  }

  @Override
  public void activate(Player player) {
    PlayerInventory inventory = player.getInventory();
    damageItem(inventory.getHelmet());
    damageItem(inventory.getChestplate());
    damageItem(inventory.getLeggings());
    damageItem(inventory.getBoots());
    damageItem(inventory.getItemInMainHand());
    damageItem(inventory.getItemInOffHand());
  }

  private void damageItem(ItemStack itemStack) {
    if (itemStack == null || itemStack.getType() == Material.AIR) {
      return;
    }
    if (itemStack instanceof Damageable damageable) {
      double maxDurability = itemStack.getType().getMaxDurability();
      float randomness = ThreadLocalRandom.current().nextFloat();
      double damage = Math.ceil(maxDurability - damageable.getDamage() * randomness);
      damageable.setDamage((int) damage);
    }

  }

}
