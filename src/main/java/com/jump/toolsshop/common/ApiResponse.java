package com.jump.toolsshop.common;

import com.jump.toolsshop.exception.ToolsShopErrorEnum;
import lombok.Data;

@Data
public class ApiResponse<T> {
    private Integer code;

    private String message;

    private Boolean success;

    private T data;

    public static final Integer OK_CODE = 10000;

    public static final String OK_MESSAGE = "success";

    public static final Boolean OK_SUCCESS = true;

    public ApiResponse(Integer code, String message, Boolean success, T data) {
        this.code = code;
        this.message = message;
        this.success = success;
        this.data = data;
    }

    public ApiResponse(Integer code, String message, Boolean success) {
        this.code = code;
        this.message = message;
        this.success = success;
    }

    public ApiResponse() {
       this(OK_CODE, OK_MESSAGE, OK_SUCCESS);
    }

    public static <T> ApiResponse<T> success() {
        return new ApiResponse<>();
    }

    public static <T> ApiResponse<T> success(T result) {
        var response = new ApiResponse<T>();
        response.setData(result);
        return response;
    }

    public static <T> ApiResponse<T> error(Integer code, String message) {
        return new ApiResponse<>(code, message, false);
    }

    public static <T> ApiResponse<T> error(ToolsShopErrorEnum exception) {
        return new ApiResponse<>(exception.getCode(), exception.getMessage(), false);
    }
}
