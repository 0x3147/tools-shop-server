package com.jump.toolsshop.exception;

public enum ToolsShopErrorEnum {
    NEED_USER_NAME(10001, "用户名不能为空"),
    NEED_USER_PASSWORD(10002, "密码不能为空"),
    NEED_USER_EMAIL(10003, "邮箱不能为空"),
    NEED_USER_PHONE(10004, "电话不能为空"),
    NEED_USER_ADDRESS(10005, "地址不能为空"),
    NEED_USER_NAME_OR_EMAIL(10006, "用户名或邮箱不能为空");

    private Integer code;

    private String message;

    ToolsShopErrorEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
