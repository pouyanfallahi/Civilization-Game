package ir.civilization.dto;

import ir.civilization.menu.play.PlayMenu;
import lombok.Data;
import org.apache.commons.cli.CommandLine;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Data
public class PlayGameDTO implements CmdLoader {

    // list of the players username
    private List<String> players = new ArrayList<>();

    @Override
    public void loadFrom(CommandLine commandLine) {
        this.players = this.loadPlayers(commandLine);
    }

    private List<String> loadPlayers(CommandLine commandLine) {
        List<String> players = Collections.emptyList();

        if (commandLine.hasOption(PlayMenu.OPTIONS_PLAYERS))
            players = Arrays.asList(
                    commandLine.getOptionValue(PlayMenu.OPTIONS_PLAYERS).split(",")
            );

        if (players.size() < 2)
            throw new IllegalStateException("at least 2 players must exist to play game!");

        return players;
    }

}
