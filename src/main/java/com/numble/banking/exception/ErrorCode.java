package com.numble.banking.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;


public enum ErrorCode {

    DUPLICATED_CLIENT_ID(HttpStatus.BAD_REQUEST, "이미 사용중인 아이디 입니다."),

    PROBLEM_WHILE_TRANSFER(HttpStatus.INTERNAL_SERVER_ERROR, "이체중 문제가 발생했습니다.");


    ;

    private final HttpStatus status;

    private final String message;

    ErrorCode(HttpStatus status, String message) {
        this.status = status;
        this.message = message;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }
}
