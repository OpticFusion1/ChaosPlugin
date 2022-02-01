package optic_fusion1.chaosplugin.user;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.UUID;

public class UserManager {

    private static final HashMap<UUID, User> USERS = new HashMap<>();

    public Collection<User> getUsers() {
        return Collections.unmodifiableCollection(USERS.values());
    }

    public User getUser(UUID uuid) {
        return USERS.get(uuid);
    }

    public void addUser(User user) {
        USERS.putIfAbsent(user.getUniqueId(), user);
    }

    public void removeUSer(UUID uuid) {
        USERS.remove(uuid);
    }
}
