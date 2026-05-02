package libs.exceptions;

public class InvalidFunctionArgException extends RuntimeException {
    public InvalidFunctionArgException(String message) {
        super(message);
    }
}
