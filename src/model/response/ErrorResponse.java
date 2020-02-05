package model.response;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class ErrorResponse {

    private final String id;
    private final String error;
    private final String message;
    private final String description;
    private final int ID_LENGTH = 5;
    private final int charA = (int) 'a';
    private final int charZPlusOne = (int) 'z' + 1;
    private List<MyFieldError> fieldErrors = new ArrayList<>();


    public ErrorResponse(String error, String message) {
        this(error, message, null);
    }

    public ErrorResponse(String code, String message, String description) {
        this.id = generateId();
        this.error = code;
        this.message = message;
        this.description = description;
    }

    private String generateId() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < ID_LENGTH; i++) {
            int ascii = ThreadLocalRandom.current().nextInt(charA, charZPlusOne);
            sb.append((char) ascii);
        }
        return sb.toString();
    }

    public String getId() {
        return id;
    }

    public String getError() {
        return error;
    }

    public String getMessage() {
        return message;
    }

    public String getDescription() {
        return description;
    }

    public void addFieldError(MyFieldError fieldError) {
        fieldErrors.add(fieldError);
    }

    public List<MyFieldError> getFieldErrors() {
        return fieldErrors;
    }

    @Override
    public String toString() {
        return "ErrorResponse{" +
                "id='" + id + '\'' +
                ", error='" + error + '\'' +
                ", message='" + message + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
