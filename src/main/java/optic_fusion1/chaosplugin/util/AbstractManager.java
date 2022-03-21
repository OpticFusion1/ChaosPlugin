package optic_fusion1.chaosplugin.util;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;

public abstract class AbstractManager<K, V> {

    private final HashMap<K, V> OBJECTS = new HashMap<>();

    public Collection<V> getAllValues() {
        return Collections.unmodifiableCollection(OBJECTS.values());
    }

    public V get(K key) {
        return OBJECTS.get(key);
    }

    public void add(K key, V value) {
        OBJECTS.putIfAbsent(key, value);
    }

    public void remove(K key) {
        OBJECTS.remove(key);
    }

    public boolean containsKey(K key) {
        return OBJECTS.containsKey(key);
    }

}
