package com.jump.toolsshop.service;

import com.jump.toolsshop.mapper.UserMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserService {
    @Resource
    UserMapper userMapper;

    public void register(String username, String email, String password) {
        var res = userMapper.selectByUserName(username);

        if (res != null) {

        }
    }
}
