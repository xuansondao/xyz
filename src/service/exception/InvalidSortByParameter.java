package service.exception;


import vn.com.vndirect.brokerinsight.service.utils.ErrorCode;

public class InvalidSortByParameter extends ErrorCodeException {

    public InvalidSortByParameter(String message) {
        super(ErrorCode.INVALID_SORT_BY_PARAM, message);
    }

    public InvalidSortByParameter(String message, Throwable cause) {
        super(ErrorCode.INVALID_SORT_BY_PARAM, message, cause);
    }

    public InvalidSortByParameter(Throwable cause) {
        super(ErrorCode.INVALID_SORT_BY_PARAM, cause);
    }
}
