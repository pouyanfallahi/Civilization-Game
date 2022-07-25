package ir.civilization.exception;

public class SamePasswordException extends RuntimeException {

    @Override
    public String getMessage() {
        return "please enter a new password";
    }
}
