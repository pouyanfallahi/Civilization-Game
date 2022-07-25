package ir.civilization.menu.map;

import ir.civilization.menu.AbstractMenu;
import ir.civilization.menu.AbstractMenuAction;
import ir.civilization.menu.map.action.ShowMapMenuAction;
import org.apache.commons.cli.Options;

import java.util.HashMap;
import java.util.Map;

public class MapMenu extends AbstractMenu {

    public static final MapMenu INSTANCE = new MapMenu();

    private static final String ACTION_SHOW = "show";

    private MapMenu() {
    }

    @Override
    public String getMenuName() {
        return "map";
    }

    @Override
    public Options getCliOptions() {
        return new Options();
    }

    @Override
    public Map<String, AbstractMenuAction<?>> getActionsMap() {
        Map<String, AbstractMenuAction<?>> actions = new HashMap<>();
        actions.put(ACTION_SHOW, ShowMapMenuAction.INSTANCE);
        return actions;
    }

}
