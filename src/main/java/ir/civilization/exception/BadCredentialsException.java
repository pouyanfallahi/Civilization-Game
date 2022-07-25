package ir.civilization.exception;

public class BadCredentialsException extends RuntimeException {

    @Override
    public String getMessage() {
        return "Username and password didn't match!";
    }

}
