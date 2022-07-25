package ir.civilization.menu.select;

import ir.civilization.menu.AbstractMenu;
import ir.civilization.menu.AbstractMenuAction;
import ir.civilization.menu.select.action.CitySelectMenuAction;
import ir.civilization.menu.select.action.UnitSelectMenuAction;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;

import java.util.HashMap;
import java.util.Map;

public class SelectMenu extends AbstractMenu {

    public static final SelectMenu INSTANCE = new SelectMenu();

    private static final String ACTION_UNIT = "unit";
    private static final String ACTION_CITY = "city";

    private static final String FLAG_X = "x";
    private static final String FLAG_Y = "y";
    private static final String FLAG_UNIT_TYPE = "unit_type";
    private static final String FLAG_NAME = "name";

    public static final Option OPTIONS_X = new Option(FLAG_X, FLAG_X, true, "x pos");
    public static final Option OPTIONS_Y = new Option(FLAG_Y, FLAG_Y, true, "y pos");
    public static final Option OPTIONS_UNIT_TYPE = new Option(FLAG_UNIT_TYPE, FLAG_UNIT_TYPE, true, "type of the unit either of COMBAT and NONCOMBAT");
    public static final Option OPTIONS_NAME = new Option(FLAG_NAME, FLAG_NAME, true, "name of the city");

    private SelectMenu() {
    }

    @Override
    public String getMenuName() {
        return "select";
    }

    @Override
    public Options getCliOptions() {
        Options options = new Options();
        options.addOption(OPTIONS_X);
        options.addOption(OPTIONS_Y);
        options.addOption(OPTIONS_UNIT_TYPE);
        options.addOption(OPTIONS_NAME);
        return options;
    }

    @Override
    public Map<String, AbstractMenuAction<?>> getActionsMap() {
        Map<String, AbstractMenuAction<?>> actions = new HashMap<>();
        actions.put(ACTION_UNIT, UnitSelectMenuAction.INSTANCE);
        actions.put(ACTION_CITY, CitySelectMenuAction.INSTANCE);
        return actions;
    }

}
