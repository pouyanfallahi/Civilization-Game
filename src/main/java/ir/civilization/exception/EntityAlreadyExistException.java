package ir.civilization.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class EntityAlreadyExistException extends RuntimeException {

    private final String entity;
    private final String prop;
    private final String value;

    @Override
    public String getMessage() {
        return String.format("%s with %s %s already exists", this.getEntity(), this.getProp(), this.getValue());
    }

}
