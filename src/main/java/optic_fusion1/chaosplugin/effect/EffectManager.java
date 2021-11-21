package optic_fusion1.chaosplugin.effect;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.concurrent.ThreadLocalRandom;

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

  public Effect getRandomEffect() {
    Effect[] effects = (Effect[]) EFFECTS.values().toArray();
    Effect effect = effects[RANDOM.nextInt(effects.length)];
    return effect;
  }

}
