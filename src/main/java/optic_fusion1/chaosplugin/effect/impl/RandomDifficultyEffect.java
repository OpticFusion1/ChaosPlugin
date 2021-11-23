package optic_fusion1.chaosplugin.effect.impl;

import java.util.concurrent.ThreadLocalRandom;
import optic_fusion1.chaosplugin.effect.TimedEffect;
import org.bukkit.Difficulty;
import org.bukkit.World;
import org.bukkit.entity.Player;

public class RandomDifficultyEffect extends TimedEffect {

  private Difficulty oldDifficulty;

  public RandomDifficultyEffect() {
    super("RandomDifficultEffect");
  }

  @Override
  public void deactivate(Player player) {
    player.getWorld().setDifficulty(oldDifficulty);
  }

  @Override
  public void activate(Player player) {
    World world = player.getWorld();
    oldDifficulty = world.getDifficulty();
    world.setDifficulty(Difficulty.values()[ThreadLocalRandom.current().nextInt(Difficulty.values().length)]);
  }

}
