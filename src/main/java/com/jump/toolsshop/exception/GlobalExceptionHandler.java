package com.jump.toolsshop.exception;

import com.jump.toolsshop.common.ApiResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Object handle(Exception e) {
        return ApiResponse.error(ToolsShopErrorEnum.SYSTEM_ERROR);
    }
}
