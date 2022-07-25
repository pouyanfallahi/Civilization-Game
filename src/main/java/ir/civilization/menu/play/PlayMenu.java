package ir.civilization.menu.play;

import ir.civilization.menu.AbstractMenu;
import ir.civilization.menu.AbstractMenuAction;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;

import java.util.HashMap;
import java.util.Map;

public class PlayMenu extends AbstractMenu {

    public static final PlayMenu INSTANCE = new PlayMenu();

    private static final String ACTION_PLAY = "game";

    private static final String FLAG_PLAYERS = "players";

    public static final Option OPTIONS_PLAYERS = new Option(FLAG_PLAYERS, FLAG_PLAYERS, true, "list of the players");

    private PlayMenu() {
    }

    @Override
    public String getMenuName() {
        return "play";
    }

    @Override
    public Options getCliOptions() {
        Options options = new Options();
        options.addOption(OPTIONS_PLAYERS);
        return options;
    }

    @Override
    public Map<String, AbstractMenuAction<?>> getActionsMap() {
        Map<String, AbstractMenuAction<?>> actions = new HashMap<>();
        actions.put(ACTION_PLAY, PlayGameMenuAction.INSTANCE);
        return actions;
    }

}
