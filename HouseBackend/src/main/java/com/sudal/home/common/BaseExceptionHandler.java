package com.sudal.home.common;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@RequiredArgsConstructor
public class BaseExceptionHandler {

    @ExceptionHandler(Exception.class)
    private ResponseEntity<GeneralResponse> BaseException(BaseException baseException) {
        GeneralResponse generalResponse = GeneralResponse.error(baseException.getResponseCode());
        return new ResponseEntity<GeneralResponse>(generalResponse, baseException.getResponseCode().getHttpStatus());
    }
}
