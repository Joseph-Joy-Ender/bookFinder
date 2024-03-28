package com.mybook.mybooklist.exceptions;

import com.mybook.mybooklist.utils.ExceptionApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(BookNotFound.class)
    public ResponseEntity<ExceptionApiResponse> notFound(BookNotFound bookNotFound){
        return new ResponseEntity<>(ExceptionApiResponse.builder()
                .data(bookNotFound.getMessage())
                .isSuccessful(false)
                .build(), HttpStatus.NOT_FOUND);
    }
}
