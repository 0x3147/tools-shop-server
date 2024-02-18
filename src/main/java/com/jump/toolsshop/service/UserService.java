package com.jump.toolsshop.service;

import com.jump.toolsshop.entity.User;
import com.jump.toolsshop.exception.ToolsShopErrorEnum;
import com.jump.toolsshop.exception.ToolsShopException;
import com.jump.toolsshop.mapper.UserMapper;
import com.jump.toolsshop.util.Argon2Util;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserService {
    @Resource
    UserMapper userMapper;
    public void login(String username, String password) throws Exception {
        var res = userMapper.selectByUserName(username);

        if (res == null) {
            throw new ToolsShopException(ToolsShopErrorEnum.USER_NOT_EXIST);
        }

        var passwordCheck = Argon2Util.verifyPassword(res.getPassword(), password);

        if (!passwordCheck) {
            throw new ToolsShopException(ToolsShopErrorEnum.USER_PASSWORD_ERROR);
        }
    }

    public void register(String username, String email, String password) throws Exception {
        var res = userMapper.selectByUserName(username);

        if (res != null) {
            throw new ToolsShopException(ToolsShopErrorEnum.USER_NAME_EXIST);
        }

        var hashPassword = Argon2Util.hashPassword(password);

        var user = new User();
        user.setUsername(username);
        user.setEmail(email);
        user.setPassword(hashPassword);

        var count = userMapper.insertSelective(user);
        if (count == 0) {
            throw new ToolsShopException(ToolsShopErrorEnum.INSERT_FAILURE);
        }
    }
}
