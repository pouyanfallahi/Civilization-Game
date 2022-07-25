package ir.civilization.exception;

public class UnAuthorizedException extends RuntimeException {

    public UnAuthorizedException() {
    }

    @Override
    public String getMessage() {
        return "you are unauthenticated";
    }
}
