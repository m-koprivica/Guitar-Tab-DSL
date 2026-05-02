package libs.exceptions;

public class InvalidMutationStatementException extends RuntimeException {
    public InvalidMutationStatementException(String message) {
        super(message);
    }
}
