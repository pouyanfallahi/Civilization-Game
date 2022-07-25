package ir.civilization.dto;

import ir.civilization.menu.select.SelectMenu;
import ir.civilization.utils.DtoUtils;
import lombok.Data;
import org.apache.commons.cli.CommandLine;

@Data
public class SelectCityDTO implements CmdLoader {

    private PositionDTO position;
    private String name;

    @Override
    public void loadFrom(CommandLine commandLine) {
        this.position = DtoUtils.createAndLoad(commandLine, PositionDTO::new);
        this.name = this.load_name(commandLine);
    }

    private String load_name(CommandLine commandLine) {
        if (commandLine.hasOption(SelectMenu.OPTIONS_NAME))
            return commandLine.getOptionValue(SelectMenu.OPTIONS_NAME);

        return null;
    }

}
