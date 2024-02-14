package com.jump.toolsshop.exception;

public enum ToolsShopErrorEnum {
    NEED_USER_NAME(10001, "用户名不能为空"),
    NEED_USER_PASSWORD(10002, "密码不能为空"),
    NEED_USER_EMAIL(10003, "邮箱不能为空"),
    USER_NAME_EXIST(10004, "该用户名已存在"),
    INSERT_FAILURE(10005, "注册失败");

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
