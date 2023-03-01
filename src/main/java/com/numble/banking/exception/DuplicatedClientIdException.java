package com.numble.banking.exception;

public class DuplicatedClientIdException extends RuntimeException{

    private final ErrorCode errorCode;

    public DuplicatedClientIdException(ErrorCode errorCode) {
        this.errorCode = errorCode;
    }

    public DuplicatedClientIdException(String message, ErrorCode errorCode) {
        super(message);
        this.errorCode = errorCode;
    }

    public DuplicatedClientIdException(String message, Throwable cause, ErrorCode errorCode) {
        super(message, cause);
        this.errorCode = errorCode;
    }

    public DuplicatedClientIdException(Throwable cause, ErrorCode errorCode) {
        super(cause);
        this.errorCode = errorCode;
    }

    public DuplicatedClientIdException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace, ErrorCode errorCode) {
        super(message, cause, enableSuppression, writableStackTrace);
        this.errorCode = errorCode;
    }

    public ErrorCode getErrorCode() {
        return errorCode;
    }
}
