package optic_fusion1.chaosplugin.user;

import optic_fusion1.chaosplugin.effect.Effect;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

public class User {

    private UUID uniqueId;
    private List<String> activeEffects = new ArrayList<>();

    public User(UUID uniqueId) {
        this.uniqueId = uniqueId;
    }

    public UUID getUniqueId() {
        return uniqueId;
    }

    public List<String> getActiveEffects() {
        return Collections.unmodifiableList(activeEffects);
    }

    public void addActiveEffect(Effect effect) {
        if (activeEffects.contains(effect.getName())) {
            return;
        }
        activeEffects.add(effect.getName());
    }

    public void removeActiveEffect(Effect effect) {
        activeEffects.remove(effect.getName());
    }

    public boolean isEffectActive(Effect effect) {
        return activeEffects.contains(effect.getName());
    }

}
