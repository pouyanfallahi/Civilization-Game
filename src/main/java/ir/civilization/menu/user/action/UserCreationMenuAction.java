package ir.civilization.menu.user.action;


import ir.civilization.dao.user.UserDao;
import ir.civilization.dto.UserDTO;
import ir.civilization.menu.AbstractMenuAction;
import ir.civilization.model.user.User;
import ir.civilization.validator.UserValidator;

public class UserCreationMenuAction extends AbstractMenuAction<UserDTO> {

    public static final UserCreationMenuAction INSTANCE = new UserCreationMenuAction();

    private UserCreationMenuAction() {
    }

    @Override
    public Class<UserDTO> getDtoClazz() {
        return UserDTO.class;
    }

    @Override
    public void takeAction(UserDTO userDTO) {
        // validate input
        UserValidator.validateUserAddition(userDTO);
        User user = new User();
        userDTO.saveTo(user);
        UserDao.INSTANCE.save(user);
        System.out.println("user created successfully!");
    }

}
