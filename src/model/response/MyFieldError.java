package model.response;

public class MyFieldError {
    private final String objectName;
    private final String fieldName;
    private final String message;

    public MyFieldError(String objectName, String fieldName, String message) {
        this.objectName = objectName;
        this.fieldName = fieldName;
        this.message = message;
    }

    public String getObjectName() {
        return objectName;
    }

    public String getFieldName() {
        return fieldName;
    }

    public String getMessage() {
        return message;
    }
}
