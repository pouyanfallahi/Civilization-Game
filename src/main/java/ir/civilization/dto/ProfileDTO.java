package ir.civilization.dto;

import ir.civilization.exception.InsufficientInputException;
import ir.civilization.menu.profile.ProfileMenu;
import ir.civilization.menu.user.UserMenu;
import lombok.Data;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.lang3.StringUtils;

@Data
public class ProfileDTO implements CmdLoader {

    private String nickname;
    private ChangePasswordDTO changePassword;

    @Override
    public void loadFrom(CommandLine commandLine) {
        this.nickname = this.loadNickname(commandLine);
        this.changePassword = this.loadChangePassword(commandLine);
    }

    protected ChangePasswordDTO loadChangePassword(CommandLine commandLine) {
        if (commandLine.hasOption(ProfileMenu.OPTIONS_PASSWORD)) {
            if (commandLine.hasOption(ProfileMenu.OPTIONS_CURRENT)
                    && commandLine.hasOption(ProfileMenu.OPTIONS_NEW))
                return ChangePasswordDTO.builder()
                        .oldPassword(commandLine.getOptionValue(ProfileMenu.OPTIONS_CURRENT))
                        .newPassword(commandLine.getOptionValue(ProfileMenu.OPTIONS_NEW))
                        .build();

            throw new InsufficientInputException("change password input not provided");
        }
        return null;
    }

    protected String loadNickname(CommandLine commandLine) {
        if (commandLine.hasOption(UserMenu.OPTIONS_NICKNAME)) {
            String nickname = commandLine.getOptionValue(UserMenu.OPTIONS_NICKNAME);
            if (StringUtils.isBlank(nickname))
                throw new InsufficientInputException("change nickname input not provided");

            return nickname;
        }

        return null;
    }

}
