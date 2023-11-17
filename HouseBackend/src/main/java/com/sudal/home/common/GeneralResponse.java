package com.sudal.home.common;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class GeneralResponse<T> {

    private Integer status;
    private Boolean success;
    private String message;
    private T data;

    public static <T> GeneralResponse<T> success(T data, String message) {
        return new GeneralResponse<>(200,true,message,data);
    }

    public static <T> GeneralResponse<T> successWithoutData(String message) {
        return new GeneralResponse<>(200,true,message,null);
    }

    public static <T> GeneralResponse<T> error(int status, String message) {
        return new GeneralResponse<>(status, false, message, null);
    }
}
