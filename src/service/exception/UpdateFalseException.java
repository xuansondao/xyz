package service.exception;

public class UpdateFalseException extends RuntimeException {
    private String message;

    public UpdateFalseException(String message){
        super(message);
        this.message = message;
    }
}
