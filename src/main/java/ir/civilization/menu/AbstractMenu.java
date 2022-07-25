package ir.civilization.menu;

import org.apache.commons.cli.*;
import org.apache.commons.collections4.MapUtils;

import java.util.Arrays;
import java.util.Map;

public abstract class AbstractMenu {

    private final static CommandLineParser COMMAND_LINE_PARSER = new DefaultParser();

    public abstract String getMenuName();

    public abstract Options getCliOptions();

    public abstract Map<String, AbstractMenuAction<?>> getActionsMap();

    // TODO make returns to exception
    public void run(String input) throws ParseException {
        String[] s = input.split(" ");
        if (s.length < 1)
            return;

        if (!s[0].equals(this.getMenuName()))
            return;

        Map<String, AbstractMenuAction<?>> actionsMap = this.getActionsMap();
        if (MapUtils.isEmpty(actionsMap))
            throw new IllegalStateException("Action map is empty!");

        AbstractMenuAction<?> action = actionsMap.get(s[1]);
        action.takeAction(this.parsArgs(Arrays.copyOfRange(s, 2, s.length)));
    }

    private CommandLine parsArgs(String[] args) throws ParseException {
        return COMMAND_LINE_PARSER.parse(getCliOptions(), args);
    }


}
