package med.voll.api.services.exceptions;

public class EntityValidationException extends RuntimeException {
    public EntityValidationException (String message) {
        super(message);
    }
}
