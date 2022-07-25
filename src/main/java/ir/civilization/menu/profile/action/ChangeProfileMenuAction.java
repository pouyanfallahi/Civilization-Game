package ir.civilization.menu.profile.action;


import ir.civilization.dao.user.UserDao;
import ir.civilization.dto.ChangePasswordDTO;
import ir.civilization.dto.ProfileDTO;
import ir.civilization.menu.AbstractMenuAction;
import ir.civilization.model.user.User;
import ir.civilization.security.AuthenticatedUserHolder;
import ir.civilization.validator.UserValidator;
import org.apache.commons.lang3.StringUtils;

public class ChangeProfileMenuAction extends AbstractMenuAction<ProfileDTO> {

    public static final ChangeProfileMenuAction INSTANCE = new ChangeProfileMenuAction();

    private final UserDao userDao = UserDao.INSTANCE;
    private final AuthenticatedUserHolder authenticatedUserHolder = AuthenticatedUserHolder.INSTANCE;

    private ChangeProfileMenuAction() {
    }

    @Override
    public Class<ProfileDTO> getDtoClazz() {
        return ProfileDTO.class;
    }

    @Override
    public void takeAction(ProfileDTO profileDTO) {
        User user = authenticatedUserHolder.getAuthenticatedUser();

        this.changeNickname(user, profileDTO);
        this.changePassword(user, profileDTO);
    }

    private void changeNickname(User user, ProfileDTO profileDTO) {
        String nickname = profileDTO.getNickname();
        if (StringUtils.isNotBlank(nickname)) {
            UserValidator.validateNickname(profileDTO);
            user.setNickname(nickname);
            userDao.update(user);
            System.out.println("nickname changed successfully!");
        }
    }

    private void changePassword(User user, ProfileDTO profileDTO) {
        ChangePasswordDTO changePassword = profileDTO.getChangePassword();
        if (changePassword != null) {
            UserValidator.validateChangePassword(user, changePassword);
            user.setPassword(changePassword.getNewPassword());
            userDao.update(user);
            System.out.println("password changed successfully!");
        }
    }

}
