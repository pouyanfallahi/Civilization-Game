package ir.civilization.security;

import ir.civilization.dao.user.UserDao;
import ir.civilization.exception.UnAuthorizedException;
import ir.civilization.exception.UserNotFountException;
import ir.civilization.model.user.User;
import org.apache.commons.lang3.StringUtils;

import java.util.Optional;

public class AuthenticatedUserHolder {

    public static final AuthenticatedUserHolder INSTANCE = new AuthenticatedUserHolder();

    private static final ThreadLocal<ExecutionContext> EC_TL = new ThreadLocal<>();

    private final UserDao userDao = UserDao.INSTANCE;

    private AuthenticatedUserHolder() {
    }

    public String getPrinciple() {
        ExecutionContext context = EC_TL.get();
        if (context == null)
            return null;

        return context.getUser().getUsername();
    }

    public User getAuthenticatedUser() {
        String principle = this.getPrinciple();
        if (StringUtils.isBlank(principle))
            throw new UnAuthorizedException();

        Optional<User> user = userDao.findByUsername(principle);
        if (!user.isPresent())
            throw new UserNotFountException();

        return user.get();
    }

    public void setPrinciple(User user) {
        ExecutionContext context = new ExecutionContext();
        context.setUser(user);
        EC_TL.set(context);
    }

    public ExecutionContext getCurrentExecutionContext() {
        return EC_TL.get();
    }

    public void removePrinciple() {
        EC_TL.remove();
    }

    public boolean isPresent(User user) {
        return user.equals(EC_TL.get().getUser());
    }

}
