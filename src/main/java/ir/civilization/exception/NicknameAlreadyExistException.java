package ir.civilization.exception;

public class NicknameAlreadyExistException extends UserAlreadyExistException {

    private static final String PROP = "nickname";

    public NicknameAlreadyExistException(String value) {
        super(PROP, value);
    }
}
