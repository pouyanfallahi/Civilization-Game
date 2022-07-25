package ir.civilization.dto;

import ir.civilization.menu.select.SelectMenu;
import ir.civilization.model.unit.UnitType;
import ir.civilization.utils.DtoUtils;
import lombok.Data;
import org.apache.commons.cli.CommandLine;

@Data
public class SelectUnitDTO implements CmdLoader {

    private PositionDTO position;
    private UnitType unitType;

    @Override
    public void loadFrom(CommandLine commandLine) {
        this.position = DtoUtils.createAndLoad(commandLine, PositionDTO::new);
        this.unitType = this.loadUnitType(commandLine);
    }

    private UnitType loadUnitType(CommandLine commandLine) {
        if (commandLine.hasOption(SelectMenu.OPTIONS_UNIT_TYPE))
            return UnitType.valueOf(commandLine.getOptionValue(SelectMenu.OPTIONS_UNIT_TYPE));

        throw new IllegalStateException("unit type cannot be null in the select menu!");
    }
}
