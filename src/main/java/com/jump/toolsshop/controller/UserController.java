package com.jump.toolsshop.controller;

import com.jump.toolsshop.common.ApiResponse;
import com.jump.toolsshop.exception.ToolsShopErrorEnum;
import com.jump.toolsshop.service.UserService;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("user")
public class UserController {
    @Resource
    UserService userService;

    @PostMapping("/login")
    @ResponseBody
    public ApiResponse login(
            @RequestParam("username") String username,
            @RequestParam("password") String password
    ) throws Exception {
        if (!StringUtils.hasText(username)) {
            return ApiResponse.error(ToolsShopErrorEnum.NEED_USER_NAME);
        }
        if (!StringUtils.hasText(password)) {
            return ApiResponse.error(ToolsShopErrorEnum.NEED_USER_PASSWORD);
        }

        userService.login(username, password);

        return ApiResponse.success();
    }

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
