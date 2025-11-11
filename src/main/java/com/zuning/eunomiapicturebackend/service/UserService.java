package com.zuning.eunomiapicturebackend.service;

import com.zuning.eunomiapicturebackend.common.ResultUtils;
import com.zuning.eunomiapicturebackend.model.dto.UserRegisterRequest;
import com.zuning.eunomiapicturebackend.model.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author wzuni
* @description 针对表【user(用户)】的数据库操作Service
* @createDate 2025-11-11 13:57:40
*/
public interface UserService extends IService<User> {

    long userRegister(UserRegisterRequest userRegisterRequest);

    String getEncryptedPassword(String password);
}
