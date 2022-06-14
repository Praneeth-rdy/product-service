package com.knorex.productservice.exceptions;

import org.springframework.http.HttpStatus;

import java.time.ZonedDateTime;

public class ApiExceptionResponse {
    private final String message;
    private final int httpStatusCode;
    private final String error;
    private final ZonedDateTime timestamp;

    public ApiExceptionResponse(String message, int httpStatusCode, String error, ZonedDateTime timestamp) {
        this.message = message;
        this.httpStatusCode = httpStatusCode;
        this.error = error;
        this.timestamp = timestamp;
    }

    public String getMessage() {
        return message;
    }

    public int getHttpStatusCode() {
        return httpStatusCode;
    }

    public String getError() {
        return error;
    }

    public ZonedDateTime getTimestamp() {
        return timestamp;
    }
}
