package com.sudal.home.common;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@RequiredArgsConstructor
public class BaseExceptionHandler {

    @ExceptionHandler(Exception.class)
    private ResponseEntity<GeneralResponse> BaseException(ResponseCode responseCode) {
        GeneralResponse generalResponse = GeneralResponse.error(responseCode);
        return new ResponseEntity<GeneralResponse>(generalResponse, responseCode.getHttpStatus());
    }
}
