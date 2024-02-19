package com.jump.toolsshop.service;

import com.jump.toolsshop.entity.User;
import com.jump.toolsshop.exception.ToolsShopErrorEnum;
import com.jump.toolsshop.exception.ToolsShopException;
import com.jump.toolsshop.mapper.UserMapper;
import com.jump.toolsshop.util.Argon2Util;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@Service
public class UserService {
    @Resource
    UserMapper userMapper;
    public Map<String, String> login(String username, String password) throws Exception {
        var res = userMapper.selectByUserName(username);

        if (res == null) {
            throw new ToolsShopException(ToolsShopErrorEnum.USER_NOT_EXIST);
        }

        var passwordCheck = Argon2Util.verifyPassword(res.getPassword(), password);

        if (!passwordCheck) {
            throw new ToolsShopException(ToolsShopErrorEnum.USER_PASSWORD_ERROR);
        }

        var infoMap = new HashMap<String, String>();
        infoMap.put("username", res.getUsername());
        infoMap.put("email", res.getEmail());

        return infoMap;
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
