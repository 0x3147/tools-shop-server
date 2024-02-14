package com.jump.toolsshop.service;

import com.jump.toolsshop.entity.User;
import com.jump.toolsshop.exception.ToolsShopErrorEnum;
import com.jump.toolsshop.exception.ToolsShopException;
import com.jump.toolsshop.mapper.UserMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserService {
    @Resource
    UserMapper userMapper;

    public void register(String username, String email, String password) throws Exception {
        var res = userMapper.selectByUserName(username);

        if (res != null) {
            throw new ToolsShopException(ToolsShopErrorEnum.USER_NAME_EXIST);
        }

        var user = new User();
        user.setUsername(username);
        user.setEmail(email);
        user.setPassword(password);

        var count = userMapper.insertSelective(user);
        if (count == 0) {
            throw new ToolsShopException(ToolsShopErrorEnum.INSERT_FAILURE);
        }
    }
}
