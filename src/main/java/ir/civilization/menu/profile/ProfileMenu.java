package ir.civilization.menu.profile;

import ir.civilization.menu.AbstractMenu;
import ir.civilization.menu.AbstractMenuAction;
import ir.civilization.menu.profile.action.ChangeProfileMenuAction;
import ir.civilization.menu.user.UserMenu;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;

import java.util.HashMap;
import java.util.Map;

public class ProfileMenu extends AbstractMenu {

    public static final ProfileMenu INSTANCE = new ProfileMenu();

    private static final String ACTION_CHANGE = "change";

    private static final String LONG_FLAG_CURRENT = "current";
    private static final String LONG_FLAG_NEW = "new";
    private static final String LONG_FLAG_PASSWORD = "password";

    public static final Option OPTIONS_CURRENT = new Option(LONG_FLAG_CURRENT, LONG_FLAG_CURRENT, true, "User's current password");
    public static final Option OPTIONS_NEW = new Option(LONG_FLAG_NEW, LONG_FLAG_NEW, true, "User's current new");
    public static final Option OPTIONS_PASSWORD = new Option(LONG_FLAG_PASSWORD, LONG_FLAG_PASSWORD, false, "User password request");;
    public static final Option OPTIONS_NICKNAME = UserMenu.OPTIONS_NICKNAME;

    private ProfileMenu() {
    }

    @Override
    public String getMenuName() {
        return "profile";
    }

    @Override
    public Options getCliOptions() {
        Options options = new Options();
        options.addOption(OPTIONS_CURRENT);
        options.addOption(OPTIONS_NEW);
        options.addOption(OPTIONS_PASSWORD);
        options.addOption(OPTIONS_NICKNAME);
        return options;
    }

    @Override
    public Map<String, AbstractMenuAction<?>> getActionsMap() {
        Map<String, AbstractMenuAction<?>> actions = new HashMap<>();
        actions.put(ACTION_CHANGE, ChangeProfileMenuAction.INSTANCE);
        return actions;
    }

}
