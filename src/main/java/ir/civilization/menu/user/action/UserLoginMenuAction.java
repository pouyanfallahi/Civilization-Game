package ir.civilization.menu.user.action;


import ir.civilization.dao.user.UserDao;
import ir.civilization.dto.UserDTO;
import ir.civilization.exception.BadCredentialsException;
import ir.civilization.menu.AbstractMenuAction;
import ir.civilization.model.user.User;
import ir.civilization.security.AuthenticatedUserHolder;

import java.util.Optional;

public class UserLoginMenuAction extends AbstractMenuAction<UserDTO> {

    public static final UserLoginMenuAction INSTANCE = new UserLoginMenuAction();

    private final UserDao userDao = UserDao.INSTANCE;
    private final AuthenticatedUserHolder authenticatedUserHolder = AuthenticatedUserHolder.INSTANCE;

    private UserLoginMenuAction() {
    }

    @Override
    public Class<UserDTO> getDtoClazz() {
        return UserDTO.class;
    }

    @Override
    public void takeAction(UserDTO userDTO) {
        Optional<User> user = userDao.findByUsernameAndPassword(userDTO.getUsername(), userDTO.getPassword());
        if (user.isPresent()) {
            authenticatedUserHolder.setPrinciple(user.get());
            System.out.println("You logged in successfully!");
        } else
            throw new BadCredentialsException();
    }

}
