package com.jump.toolsshop.exception;

import com.jump.toolsshop.common.ApiResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger LOG = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Object handle(Exception e) {

        LOG.error("默认异常：", e);

        return ApiResponse.error(ToolsShopErrorEnum.SYSTEM_ERROR);
    }

    @ExceptionHandler(ToolsShopException.class)
    @ResponseBody
    public Object handleToolsShopException(ToolsShopException e) {

        LOG.error("自定义异常：", e);

        return ApiResponse.error(e.getCode(), e.getMessage());
    }
}
