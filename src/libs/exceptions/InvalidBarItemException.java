package libs.exceptions;

public class InvalidBarItemException extends RuntimeException {
    public InvalidBarItemException(String message) {
        super(message);
    }
}
