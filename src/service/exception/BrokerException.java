package service.exception;


import vn.com.vndirect.brokerinsight.service.utils.ErrorCode;

public class BrokerException extends ErrorCodeException {
    public BrokerException(String message) {
        super(ErrorCode.BROKER_NOT_FOUND, message);
    }

    public BrokerException(ErrorCode errorCode, String message, Throwable cause) {
        super(errorCode, message, cause);
    }

    public BrokerException(ErrorCode errorCode, Throwable cause) {
        super(errorCode, cause);
    }
}
