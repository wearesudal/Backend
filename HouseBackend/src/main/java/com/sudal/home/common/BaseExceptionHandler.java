package com.sudal.home.common;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@RequiredArgsConstructor
public class BaseExceptionHandler {

    @ExceptionHandler(Exception.class)
    private ResponseEntity<GeneralResponse> BaseException(BaseException e) {
        GeneralResponse generalResponse = GeneralResponse.error(HttpStatus.BAD_REQUEST,e.getMessage());
        return new ResponseEntity<GeneralResponse>(generalResponse, HttpStatus.BAD_REQUEST);
    }
}
