package ir.civilization.menu.unit;

import ir.civilization.menu.AbstractMenu;
import ir.civilization.menu.AbstractMenuAction;
import ir.civilization.menu.unit.action.DeleteUnitMenuAction;
import ir.civilization.menu.unit.action.FoundCityMenuAction;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;

import java.util.HashMap;
import java.util.Map;

public class UnitMenu extends AbstractMenu {

    public static final UnitMenu INSTANCE = new UnitMenu();

    private static final String ACTION_MOVETO = "moveto";
    private static final String ACTION_DELETE = "delete";
    private static final String FOUND = "found";

    private static final String FLAG_X = "x";
    private static final String FLAG_Y = "y";
    private static final String FLAG_CITY = "city";

    public static final Option OPTIONS_X = new Option(FLAG_X, FLAG_X, true, "x pos");
    public static final Option OPTIONS_Y = new Option(FLAG_Y, FLAG_Y, true, "y pos");
    public static final Option OPTIONS_CITY = new Option(FLAG_CITY, FLAG_CITY, false, "city");


    private UnitMenu() {
    }

    @Override
    public String getMenuName() {
        return "unit";
    }

    @Override
    public Options getCliOptions() {
        Options options = new Options();
        options.addOption(OPTIONS_X);
        options.addOption(OPTIONS_Y);
        options.addOption(OPTIONS_CITY);
        return options;
    }

    @Override
    public Map<String, AbstractMenuAction<?>> getActionsMap() {
        Map<String, AbstractMenuAction<?>> actions = new HashMap<>();
        actions.put(ACTION_MOVETO, MoveToUnitMenuAction.INSTANCE);
        actions.put(ACTION_DELETE, DeleteUnitMenuAction.INSTANCE);
        actions.put(FOUND, FoundCityMenuAction.INSTANCE);
        return actions;
    }

}
