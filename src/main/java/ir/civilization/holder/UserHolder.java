package ir.civilization.holder;

import ir.civilization.model.user.User;

import java.util.Collection;
import java.util.HashSet;

public class UserHolder implements ObjectHolder<User> {

    public static final UserHolder INSTANCE = new UserHolder();

    private static final Collection<User> USERS = new HashSet<>();

    private UserHolder() {
    }

    @Override
    public void cache(User user) {
        this.remove(user);
        USERS.add(user);
    }

    @Override
    public void remove(User user) {
        USERS.remove(user);
    }

    @Override
    public void clearCache() {
        USERS.clear();
    }

    @Override
    public Collection<User> getAll() {
        return USERS;
    }

    @Override
    public boolean isPresent(User user) {
        return USERS.contains(user);
    }

}
