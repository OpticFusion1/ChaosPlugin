package optic_fusion1.chaosplugin.effect;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import optic_fusion1.chaosplugin.ChaosPlugin;
import optic_fusion1.chaosplugin.util.CollectionUtils;

public class EffectManager {

    private static final HashMap<String, Effect> ALL_EFFECTS = new HashMap<>();
    private static final HashMap<String, Effect> ENABLED_EFFECTS = new HashMap<>();
    private static final HashMap<String, TimedEffect> TIMED_EFFECTS = new HashMap<>();
    private List<String> disabledEffects = new ArrayList<>();

    public EffectManager(ChaosPlugin chaos) {
        disabledEffects = chaos.getConfig().getStringList("settings.disabled-effects");
    }

    public void addEffect(Effect effect) {
        ALL_EFFECTS.put(effect.getName(), effect);
        if (!disabledEffects.contains(effect.getName())) {
            ENABLED_EFFECTS.put(effect.getName(), effect);
        }
    }

    public Collection<Effect> getAllEffects() {
        return Collections.unmodifiableCollection(ALL_EFFECTS.values());
    }

    public Collection<Effect> getEnabledEffects() {
        return Collections.unmodifiableCollection(ENABLED_EFFECTS.values());
    }

    public Effect getEffectByName(String name) {
        return ALL_EFFECTS.get(name);
    }

    public Effect getEnabledEffectByName(String name) {
        return ENABLED_EFFECTS.get(name);
    }

    public Optional<Effect> getRandomEffect() {
        return CollectionUtils.getRandomCollectionElement(ALL_EFFECTS.values());
    }

    public Optional<Effect> getRandomEnabledEffect() {
        return CollectionUtils.getRandomCollectionElement(ENABLED_EFFECTS.values());
    }

}
