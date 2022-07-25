package ir.civilization.menu.info;

import ir.civilization.menu.AbstractMenu;
import ir.civilization.menu.AbstractMenuAction;
import ir.civilization.menu.info.action.CityInfoMenuAction;
import ir.civilization.menu.info.action.UnitsInfoMenuAction;
import org.apache.commons.cli.Options;

import java.util.HashMap;
import java.util.Map;

public class InfoMenu extends AbstractMenu {

    public static final InfoMenu INSTANCE = new InfoMenu();

    private static final String ACTION_UNITS = "units";
    private static final String ACTION_CITIES = "cities";
    private static final String ACTION_DIPLOMACY = "diplomacy";
    private static final String ACTION_VICTORY = "victory";
    private static final String ACTION_DEMOGRAPHICS = "demographics";
    private static final String ACTION_NOTIFICATIONS = "notifications";
    private static final String ACTION_MILITARY = "military";
    private static final String ACTION_ECONOMIC = "economic";
    private static final String ACTION_DIPLOMATIC = "diplomatic";
    private static final String ACTION_DEALS = "deals";

    private InfoMenu() {
    }

    @Override
    public String getMenuName() {
        return "profile";
    }

    @Override
    public Options getCliOptions() {
        return new Options();
    }

    @Override
    public Map<String, AbstractMenuAction<?>> getActionsMap() {
        Map<String, AbstractMenuAction<?>> actions = new HashMap<>();
        actions.put(ACTION_UNITS, UnitsInfoMenuAction.INSTANCE);
        actions.put(ACTION_CITIES, CityInfoMenuAction.INSTANCE);
        return actions;
    }

}
