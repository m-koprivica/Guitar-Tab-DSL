package libs.exceptions;

public class InvalidParamTypeException extends RuntimeException {
    public InvalidParamTypeException(String message) {
        super(message);
    }
}
