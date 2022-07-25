package ir.civilization.dto;

import ir.civilization.menu.unit.UnitMenu;
import lombok.Getter;
import org.apache.commons.cli.CommandLine;

@Getter
public class PositionDTO implements CmdLoader {

    private int x;
    private int y;

    @Override
    public void loadFrom(CommandLine commandLine) {
        this.x = this.loadX(commandLine);
        this.y = this.loadY(commandLine);
    }

    private int loadX(CommandLine commandLine) {
        if (commandLine.hasOption(UnitMenu.OPTIONS_X))
            return Integer.parseInt(commandLine.getOptionValue(UnitMenu.OPTIONS_X));

        return -1;
    }

    private int loadY(CommandLine commandLine) {
        if (commandLine.hasOption(UnitMenu.OPTIONS_Y))
            return Integer.parseInt(commandLine.getOptionValue(UnitMenu.OPTIONS_Y));

        return -1;
    }
}
