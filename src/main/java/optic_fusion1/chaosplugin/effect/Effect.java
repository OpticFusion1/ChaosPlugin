package optic_fusion1.chaosplugin.effect;

import org.bukkit.entity.Player;

// TODO: Better implement Timed effects (e.g instant, long, short, permanent, custom)
// TODO: Better implement global effects. Not every effect needs to have a player passed to it
public abstract class Effect {

    private String name;
    private boolean isGlobal;

    public Effect(String name) {
        this(name, false);
    }

    public Effect(String name, boolean isGlobal) {
        this.name = name;
        this.isGlobal = isGlobal;
    }

    public abstract void activate(Player player);

    public String getName() {
        return name;
    }

    public boolean isGlobal() {
        return isGlobal;
    }

}
