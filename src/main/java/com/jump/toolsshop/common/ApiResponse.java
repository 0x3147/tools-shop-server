package com.jump.toolsshop.common;

import com.jump.toolsshop.exception.ToolsShopErrorEnum;

public class ApiResponse<T> {
    private Integer status;

    private String message;

    private Boolean success;

    private T data;

    public static final Integer OK_CODE = 10000;

    public static final String OK_MESSAGE = "success";

    public static final Boolean OK_SUCCESS = true;

    public ApiResponse(Integer status, String message, Boolean success, T data) {
        this.status = status;
        this.message = message;
        this.success = success;
        this.data = data;
    }

    public ApiResponse(Integer status, String message, Boolean success) {
        this.status = status;
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

    public static <T> ApiResponse<T> error(Integer status, String message) {
        return new ApiResponse<>(status, message, false);
    }

    public static <T> ApiResponse<T> error(ToolsShopErrorEnum exception) {
        return new ApiResponse<>(exception.getCode(), exception.getMessage(), false);
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
