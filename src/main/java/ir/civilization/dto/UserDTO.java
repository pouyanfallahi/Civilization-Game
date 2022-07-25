package ir.civilization.dto;

import ir.civilization.menu.user.UserMenu;
import ir.civilization.model.user.User;
import lombok.Data;
import org.apache.commons.cli.CommandLine;

@Data
public class UserDTO implements CmdLoader, DtoSaver<User> {

    private String username;
    private String password;
    private String nickname;

    @Override
    public void loadFrom(CommandLine commandLine) {
        this.username = this.loadUsername(commandLine);
        this.password = this.loadPassword(commandLine);
        this.nickname = this.loadNickname(commandLine);
    }

    protected String loadUsername(CommandLine commandLine) {
        if (commandLine.hasOption(UserMenu.OPTIONS_USERNAME))
            return commandLine.getOptionValue(UserMenu.OPTIONS_USERNAME);

        return null;
    }

    protected String loadPassword(CommandLine commandLine) {
        if (commandLine.hasOption(UserMenu.OPTIONS_PASSWORD))
            return commandLine.getOptionValue(UserMenu.OPTIONS_PASSWORD);

        return null;
    }

    protected String loadNickname(CommandLine commandLine) {
        if (commandLine.hasOption(UserMenu.OPTIONS_NICKNAME))
            return commandLine.getOptionValue(UserMenu.OPTIONS_NICKNAME);

        return null;
    }

    @Override
    public void saveTo(User user) {
        user.setUsername(this.getUsername());
        user.setPassword(this.getPassword());
        user.setNickname(this.getNickname());
    }
}
