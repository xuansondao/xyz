package service.utils;

import org.springframework.http.HttpStatus;

import java.util.Arrays;

public enum ErrorCode {
    INTERNAL_SERVER_ERROR("SERISE", "Internal server error", HttpStatus.INTERNAL_SERVER_ERROR),
    INVALID_SORT_BY_PARAM("CLIISBP", "Invalid sortBy parameter.", HttpStatus.BAD_REQUEST),
    HR_CODE_EXISTED(Code.HR_CODE_EXISTED, "Invalid HR_CODE_EXISTED parameter.", HttpStatus.BAD_REQUEST),
    BROKER_ID(Code.BROKER_ID, "Invalid broker_id existed", HttpStatus.BAD_REQUEST),
    BROKER_CUSTOMER_ID(Code.BROKER_CUSTOMER_ID, "Invalid BROKER_CUSTOMER_ID existed", HttpStatus.BAD_REQUEST),
    VND_EMAIL(Code.VND_EMAIL, "Invalid VND_EMAIL existed.", HttpStatus.BAD_REQUEST),
    USER_ID(Code.USER_ID, "Invalid USER_ID existed.", HttpStatus.BAD_REQUEST),
    BROKER_USERNAME(Code.BROKER_USERNAME, "Invalid BROKER_USERNAME existed.", HttpStatus.BAD_REQUEST),
    BROKER_NOT_FOUND("BRNF", "Invalid BROKER_CUSTOMER_ID existed", HttpStatus.NOT_FOUND);

    private String code;
    private String description;
    private HttpStatus httpStatus;

    ErrorCode(String code, String description, HttpStatus httpStatus) {
        this.code = code;
        this.description = description;
        this.httpStatus = httpStatus;
    }

    public static String getDescription(String code){
        return Arrays.stream(values()).filter(errorCode -> errorCode.code.equals(code)).findFirst().get().description();
    }

    public String code() {
        return code;
    }

    public String description() {
        return description;
    }

    public HttpStatus httpStatus() {
        return httpStatus;
    }

    public interface  Code{
        String HR_CODE_EXISTED = "001";
        String BROKER_ID = "002";
        String BROKER_CUSTOMER_ID = "003";
        String VND_EMAIL = "004";
        String USER_ID = "005";
        String BROKER_USERNAME = "006";
    }

}
