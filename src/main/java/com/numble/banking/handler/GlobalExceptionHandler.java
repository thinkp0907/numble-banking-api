package com.numble.banking.handler;

import com.numble.banking.exception.DuplicatedClientIdException;
import com.numble.banking.exception.ErrorCode;
import com.numble.banking.exception.ErrorResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.HttpServerErrorException;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(DuplicatedClientIdException.class)
    public ResponseEntity<ErrorResponse> handleDuplicatedClientIdException(DuplicatedClientIdException e) {
        log.error("handleDuplicatedClientIdException : {} ", e.getMessage());

        return ResponseEntity
                .status(ErrorCode.DUPLICATED_CLIENT_ID.getStatus().value())
                .body(new ErrorResponse(ErrorCode.DUPLICATED_CLIENT_ID));
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleInternalServerException(Exception e) {
        log.error("handleInternalServerException : {} ", e.getMessage());

        return ResponseEntity
                .status(ErrorCode.PROBLEM_WHILE_TRANSFER.getStatus().value())
                .body(new ErrorResponse(ErrorCode.PROBLEM_WHILE_TRANSFER));
    }

}
