package ir.civilization.exception;

public class UserNotFountException extends RuntimeException {

    public UserNotFountException() {
    }

    public UserNotFountException(String message) {
        super(message);
    }
}
