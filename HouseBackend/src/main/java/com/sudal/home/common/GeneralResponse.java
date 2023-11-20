package com.sudal.home.common;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@Getter
@AllArgsConstructor
public class GeneralResponse<T> {

    private int status;
    private Boolean success;
    private String message;
    private T data;

    public static <T> ResponseEntity<GeneralResponse> success(HttpStatus status, T data, String message) {
        GeneralResponse<T> generalResponse = new GeneralResponse<>(status.value(),true,message,data);
        return new ResponseEntity<GeneralResponse>(generalResponse, status);
    }

    public static <T> ResponseEntity<GeneralResponse> successWithoutData(HttpStatus status, String message) {
        GeneralResponse<T> generalResponse = new GeneralResponse<>(status.value(),true,message,null);
        return new ResponseEntity<GeneralResponse>(generalResponse, status);
    }

    public static <T> GeneralResponse<T> error(HttpStatus status, String message) {
        return new GeneralResponse<>(status.value(), false, message, null);
    }
}