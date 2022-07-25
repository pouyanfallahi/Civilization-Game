package ir.civilization.exception;

public class UsernameAlreadyExistException extends UserAlreadyExistException {

    private static final String PROP = "username";

    public UsernameAlreadyExistException(String value) {
        super(PROP, value);
    }
}
