package com.jump.toolsshop.controller;

import com.jump.toolsshop.common.ApiResponse;
import com.jump.toolsshop.exception.ToolsShopErrorEnum;
import com.jump.toolsshop.service.UserService;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class UserController {
    @Resource
    UserService userService;

    @PostMapping("/register")
    @ResponseBody
    public ApiResponse register(
            @RequestParam("username") String username,
            @RequestParam("email") String email,
            @RequestParam("password") String password
    ) throws Exception {
        if (!StringUtils.hasText(username)) {
            return ApiResponse.error(ToolsShopErrorEnum.NEED_USER_NAME);
        }
        if (!StringUtils.hasText(email)) {
            return ApiResponse.error(ToolsShopErrorEnum.NEED_USER_EMAIL);
        }
        if (!StringUtils.hasText(password)) {
            return ApiResponse.error(ToolsShopErrorEnum.NEED_USER_PASSWORD);
        }

        userService.register(username, email, password);

        return ApiResponse.success();
    }
}
