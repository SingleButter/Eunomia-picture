package com.zuning.eunomiapicturebackend.service.impl;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zuning.eunomiapicturebackend.exception.ErrorCode;
import com.zuning.eunomiapicturebackend.exception.ThrowUtils;
import com.zuning.eunomiapicturebackend.model.dto.UserRegisterRequest;
import com.zuning.eunomiapicturebackend.model.entity.User;
import com.zuning.eunomiapicturebackend.model.enums.UserRoleEnum;
import com.zuning.eunomiapicturebackend.service.UserService;
import com.zuning.eunomiapicturebackend.mapper.UserMapper;
import net.bytebuddy.implementation.bytecode.Throw;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;
import org.springframework.util.StringUtils;

/**
* @author wzuni
* @description 针对表【user(用户)】的数据库操作Service实现
* @createDate 2025-11-11 13:57:40
*/
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
    implements UserService{


    @Override
    public long userRegister(UserRegisterRequest userRegisterRequest) {
        String userAccount = userRegisterRequest.getUserAccount();
        String userPassword = userRegisterRequest.getUserPassword();
        String checkPassword = userRegisterRequest.getCheckPassword();
        //校验参数
        ThrowUtils.throwIf(StrUtil.hasBlank(userPassword,userAccount,checkPassword), ErrorCode.PARAMS_ERROR, "参数为空");
        ThrowUtils.throwIf(userAccount.length()<4, ErrorCode.PARAMS_ERROR,"用户账号过短");
        ThrowUtils.throwIf(userPassword.length()<6||checkPassword.length()<6, ErrorCode.PARAMS_ERROR,"用户密码过短");
        ThrowUtils.throwIf(!userPassword.equals(checkPassword), ErrorCode.PARAMS_ERROR,"密码不匹配");
        //检查用户账户是否在数据库中已经存在
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("userAccount", userAccount);
        ThrowUtils.throwIf(this.getOne(queryWrapper) != null, ErrorCode.PARAMS_ERROR, "用户账户已经存在");

        //密码要加密和撒盐
        String encryptedPassword = getEncryptedPassword(userPassword);
        //将数据插入数据库
        User user = new User();
        user.setUserAccount(userAccount);
        user.setUserPassword(encryptedPassword);
        user.setUserName("无名");
        user.setUserRole(UserRoleEnum.USER.getValue());
        boolean result = this.save(user);
        ThrowUtils.throwIf(!result, ErrorCode.SYSTEM_ERROR,"注册失败，数据库错误");
        return user.getId();
    }

    @Override
    public String getEncryptedPassword(String password) {
        final String SALT = "ning";
        return DigestUtils.md5DigestAsHex((SALT + password).getBytes());
    }
}




