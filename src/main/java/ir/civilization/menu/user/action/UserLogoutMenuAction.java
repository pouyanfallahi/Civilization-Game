package ir.civilization.menu.user.action;


import ir.civilization.dao.user.UserDao;
import ir.civilization.dto.EmptyCmdLoader;
import ir.civilization.menu.AbstractMenuAction;
import ir.civilization.security.AuthenticatedUserHolder;

public class UserLogoutMenuAction extends AbstractMenuAction<EmptyCmdLoader> {

    public static final UserLogoutMenuAction INSTANCE = new UserLogoutMenuAction();

    private final UserDao userDao = UserDao.INSTANCE;
    private final AuthenticatedUserHolder authenticatedUserHolder = AuthenticatedUserHolder.INSTANCE;

    private UserLogoutMenuAction() {
    }

    @Override
    public Class<EmptyCmdLoader> getDtoClazz() {
        return EmptyCmdLoader.class;
    }

    @Override
    public void takeAction(EmptyCmdLoader emptyCmdLoader) {
        authenticatedUserHolder.removePrinciple();
        System.out.println("you logged out successfully!");
    }

}
