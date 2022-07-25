package ir.civilization.menu.user;

import ir.civilization.menu.AbstractMenu;
import ir.civilization.menu.AbstractMenuAction;
import ir.civilization.menu.user.action.UserCreationMenuAction;
import ir.civilization.menu.user.action.UserLoginMenuAction;
import ir.civilization.menu.user.action.UserLogoutMenuAction;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;

import java.util.HashMap;
import java.util.Map;

public class UserMenu extends AbstractMenu {

    public static final UserMenu INSTANCE = new UserMenu();

    private static final String ACTION_CREATE = "create";
    private static final String ACTION_LOGIN = "login";
    private static final String ACTION_LOGOUT = "logout";

    private static final String FLAG_USERNAME = "u";
    private static final String LONG_FLAG_USERNAME = "username";
    private static final String FLAG_PASSWORD = "p";
    private static final String LONG_FLAG_PASSWORD = "password";
    private static final String FLAG_NICKNAME = "n";
    private static final String LONG_FLAG_NICKNAME = "nickname";

    public static final Option OPTIONS_USERNAME = new Option(FLAG_USERNAME, LONG_FLAG_USERNAME, true, "User's username");
    public static final Option OPTIONS_PASSWORD = new Option(FLAG_PASSWORD, LONG_FLAG_PASSWORD, true, "User's password");
    public static final Option OPTIONS_NICKNAME = new Option(FLAG_NICKNAME, LONG_FLAG_NICKNAME, true, "User's nickname");

    private UserMenu() {
    }

    @Override
    public String getMenuName() {
        return "user";
    }

    @Override
    public Options getCliOptions() {
        Options options = new Options();
        options.addOption(OPTIONS_USERNAME);
        options.addOption(OPTIONS_PASSWORD);
        options.addOption(OPTIONS_NICKNAME);
        return options;
    }

    @Override
    public Map<String, AbstractMenuAction<?>> getActionsMap() {
        Map<String, AbstractMenuAction<?>> actions = new HashMap<>();
        actions.put(ACTION_CREATE, UserCreationMenuAction.INSTANCE);
        actions.put(ACTION_LOGIN, UserLoginMenuAction.INSTANCE);
        actions.put(ACTION_LOGOUT, UserLogoutMenuAction.INSTANCE);
        return actions;
    }

}
