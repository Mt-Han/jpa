package com.example.test.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

public class ApiResponseException extends RuntimeException {

    @Getter
    private final String message;

    @Getter
    private final HttpStatus httpStatus;

    public ApiResponseException(String message, HttpStatus httpStatus) {
        super(message);
        this.message = message;
        this.httpStatus = httpStatus;
    }
}
