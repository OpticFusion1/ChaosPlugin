package optic_fusion1.chaosplugin.effect;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Optional;
import java.util.concurrent.ThreadLocalRandom;
import optic_fusion1.chaosplugin.util.Utils;

public class EffectManager {

  private static final HashMap<String, Effect> EFFECTS = new HashMap<>();
  private static final ThreadLocalRandom RANDOM = ThreadLocalRandom.current();

  public void addEffect(Effect effect) {
    EFFECTS.put(effect.getName(), effect);
  }

  public Collection<Effect> getEffects() {
    return Collections.unmodifiableCollection(EFFECTS.values());
  }

  public Effect getEffect(String name) {
    return EFFECTS.get(name);
  }

  public Optional<Effect> getRandomEffect() {
    return Utils.getRandom(EFFECTS.values());
  }

}
