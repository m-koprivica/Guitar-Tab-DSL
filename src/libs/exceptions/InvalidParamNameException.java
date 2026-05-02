package libs.exceptions;

public class InvalidParamNameException extends RuntimeException {
    public InvalidParamNameException(String message) {
        super(message);
    }
}
