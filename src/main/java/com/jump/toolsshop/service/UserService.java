package com.jump.toolsshop.service;

import com.github.yitter.idgen.YitIdHelper;
import com.jump.toolsshop.dto.UserInfoDto;
import com.jump.toolsshop.entity.User;
import com.jump.toolsshop.exception.ToolsShopErrorEnum;
import com.jump.toolsshop.exception.ToolsShopException;
import com.jump.toolsshop.mapper.UserMapper;
import com.jump.toolsshop.util.Argon2Util;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    @Transactional(rollbackFor = Exception.class)
    public void register(String username, String email, String password) throws Exception {
        var res = userMapper.selectByUserName(username);

        if (res != null) {
            throw new ToolsShopException(ToolsShopErrorEnum.USER_NAME_EXIST);
        }

        var hashPassword = Argon2Util.hashPassword(password);

        try {
            var user = new User();
            var postId = YitIdHelper.nextId();
            user.setPostId(postId);
            user.setUsername(username);
            user.setEmail(email);
            user.setPassword(hashPassword);

            var count = userMapper.insertSelective(user);
            if (count == 0) {
                throw new ToolsShopException(ToolsShopErrorEnum.INSERT_FAILURE);
            }
        } catch (DataAccessException e) {
            throw new ToolsShopException(ToolsShopErrorEnum.DATABASE_ERROR);
        }
    }

    public UserInfoDto getUserInfo(Long postId) throws Exception {
        var currentUser = userMapper.selectByPostId(postId);

        if (currentUser == null) {
            throw new ToolsShopException(ToolsShopErrorEnum.USER_NOT_EXIST);
        }

        var userInfo = new UserInfoDto();
        userInfo.setPostId(currentUser.getPostId());
        userInfo.setUsername(currentUser.getUsername());

        return userInfo;
    }
}
