package com.sudal.home.common;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.ResponseEntity;

@Getter
@AllArgsConstructor
public class GeneralResponse<T> {

    private int status;
    private Boolean success;
    private String message;
    private T data;

    public static <T> ResponseEntity<GeneralResponse> success(ResponseCode responseCode, T data) {
        GeneralResponse<T> generalResponse = new GeneralResponse<>(responseCode.getHttpStatus().value(),true, responseCode.getMessage(),data);
        return new ResponseEntity<GeneralResponse>(generalResponse, responseCode.getHttpStatus());
    }

    public static <T> ResponseEntity<GeneralResponse> successWithoutData(ResponseCode responseCode) {
        GeneralResponse<T> generalResponse = new GeneralResponse<>(responseCode.getHttpStatus().value(),true, responseCode.getMessage(),null);
        return new ResponseEntity<GeneralResponse>(generalResponse, responseCode.getHttpStatus());
    }

    public static <T> GeneralResponse<T> error(ResponseCode responseCode) {
        return new GeneralResponse<>(responseCode.getHttpStatus().value(), false, responseCode.getMessage(), null);
    }
}