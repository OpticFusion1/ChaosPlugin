package optic_fusion1.chaosplugin.util;

import java.util.Collection;
import java.util.Optional;
import java.util.Random;
import java.util.Set;

public final class CollectionUtils {

    private CollectionUtils() {
    }

    public static <E> Optional<E> getRandomCollectionElement(Collection<E> e) {
        return e.stream().skip((int) (e.size() * Math.random())).findFirst();
    }

    public static <E> E getRandomSetElement(Set<E> set) {
        return set.stream().skip(new Random().nextInt(set.size())).findFirst().orElse(null);
    }

}
