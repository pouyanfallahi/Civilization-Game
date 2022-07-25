package ir.civilization.exception;

public class InsufficientInputException extends RuntimeException {

    public InsufficientInputException() {}

    public InsufficientInputException(String message) {
        super(message);
    }
}
