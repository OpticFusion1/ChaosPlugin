package optic_fusion1.chaosplugin.util;

import static java.lang.Math.random;
import java.util.Collection;
import java.util.HashMap;
import java.util.Optional;
import java.util.Random;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.util.Vector;

public final class Utils {

    private Utils() {
    }

    public static String colorize(String string) {
        Pattern pattern = Pattern.compile("#[a-fA-F0-9]{6}");
        for (Matcher matcher = pattern.matcher(string); matcher.find(); matcher = pattern.matcher(string)) {
            String color = string.substring(matcher.start(), matcher.end());
            string = string.replace(color, net.md_5.bungee.api.ChatColor.of(color) + "");
        }
        string = ChatColor.translateAlternateColorCodes('&', string);
        return string;
    }

    public static Location getLocationInCircle(Location origin, Integer radius) {
        double angle = random() * 360;
        return origin.add(Math.cos(angle) * radius, 0, Math.sin(angle) * radius);
    }

    public static void launchEntity(Entity entity) {
        Location location = entity.getLocation();
        location.setPitch(-90);
        entity.teleport(location);
        Vector direction = location.getDirection();
        entity.setVelocity(direction.multiply(50.0));
    }

    public static void addItems(Player player, ItemStack[] items) {
        Inventory inventory = player.getInventory();
        HashMap<Integer, ItemStack> remainingItems = inventory.addItem(items);
        for (ItemStack itemStack : remainingItems.values()) {
            Location location = player.getLocation();
            location.getWorld().dropItemNaturally(location, itemStack);
        }
    }

}
