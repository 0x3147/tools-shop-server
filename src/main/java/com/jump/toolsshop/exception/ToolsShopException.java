package com.jump.toolsshop.exception;

public class ToolsShopException extends Exception {
    private final Integer code;

    private final String message;

    public ToolsShopException(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public ToolsShopException(ToolsShopErrorEnum exception) {
        this(exception.getCode(), exception.getMessage());
    }

    public Integer getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
