package com.knorex.productservice.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.ZoneId;
import java.time.ZonedDateTime;

@ControllerAdvice
public class ApiExceptionHandler {

    @ExceptionHandler(value = {BadRequestException.class})
    public ResponseEntity<Object> handleBadRequestException(BadRequestException exception) {
        // Create payload containing exception details
        HttpStatus badRequest = HttpStatus.resolve(400);
        ApiExceptionResponse apiExceptionResponse = new ApiExceptionResponse(
                exception.getMessage(),
                badRequest.value(),
                badRequest.getReasonPhrase(),
                ZonedDateTime.now(ZoneId.of("GMT+05:30"))
        );
        // Return response entity

        return new ResponseEntity<>(apiExceptionResponse, badRequest);
    }

    @ExceptionHandler(value = {ResourceNotFoundException.class})
    public ResponseEntity<Object> handleResourceNotFoundException(ResourceNotFoundException exception) {
        HttpStatus resourceNotFound = HttpStatus.resolve(404);
        ApiExceptionResponse apiExceptionResponse = new ApiExceptionResponse(
                exception.getMessage(),
                resourceNotFound.value(),
                resourceNotFound.getReasonPhrase(),
                ZonedDateTime.now(ZoneId.of("GMT+05:30"))
        );

        return new ResponseEntity<>(apiExceptionResponse, resourceNotFound);
    }


    @ExceptionHandler(value = {RuntimeException.class})
    public ResponseEntity<Object> handleRuntimeException(RuntimeException exception) {
        // Create payload containing exception details
        HttpStatus internalServerError = HttpStatus.resolve(500);
        ApiExceptionResponse apiExceptionResponse = new ApiExceptionResponse(
                exception.getMessage(),
                internalServerError.value(),
                internalServerError.getReasonPhrase(),
                ZonedDateTime.now(ZoneId.of("GMT+05:30"))
        );
        // Return response entity
        // System.out.println(exception);

        return new ResponseEntity<>(apiExceptionResponse, internalServerError);
    }


}
