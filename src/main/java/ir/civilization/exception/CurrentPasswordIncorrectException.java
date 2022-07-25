package ir.civilization.exception;

public class CurrentPasswordIncorrectException extends RuntimeException {

    @Override
    public String getMessage() {
        return "current password is invalid";
    }
}
