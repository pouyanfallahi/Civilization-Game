package ir.civilization.exception;

public class UserAlreadyExistException extends EntityAlreadyExistException {

    private static final String ENTITY = "user";

    public UserAlreadyExistException(String prop, String value) {
        super(ENTITY, prop, value);
    }
}
