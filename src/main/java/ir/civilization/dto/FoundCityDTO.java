package ir.civilization.dto;

import ir.civilization.menu.unit.UnitMenu;
import lombok.Getter;
import org.apache.commons.cli.CommandLine;

@Getter
public class FoundCityDTO implements CmdLoader {

    private boolean hasCityFlag;

    @Override
    public void loadFrom(CommandLine commandLine) {
        this.hasCityFlag = this.load_hasCity(commandLine);
    }

    private boolean load_hasCity(CommandLine commandLine) {
        return commandLine.hasOption(UnitMenu.OPTIONS_CITY);
    }

}
