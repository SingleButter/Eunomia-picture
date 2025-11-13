package com.zuning.eunomiapicturebackend.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zuning.eunomiapicturebackend.model.dto.user.UserLoginRequest;
import com.zuning.eunomiapicturebackend.model.dto.user.UserQueryRequest;
import com.zuning.eunomiapicturebackend.model.dto.user.UserRegisterRequest;
import com.zuning.eunomiapicturebackend.model.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;
import com.zuning.eunomiapicturebackend.model.vo.LoginUserVO;
import com.zuning.eunomiapicturebackend.model.vo.UserVO;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
* @author wzuni
* @description 针对表【user(用户)】的数据库操作Service
* @createDate 2025-11-11 13:57:40
*/
public interface UserService extends IService<User> {

    long userRegister(UserRegisterRequest userRegisterRequest);

    String getEncryptedPassword(String password);

    LoginUserVO userLogin(UserLoginRequest userLoginRequest, HttpServletRequest request);

    /**
     * 获取脱敏的已登录用户信息
     *
     * @return
     */
    LoginUserVO getLoginUserVO(User user);

    /**
     * 获取当前登录用户
     *
     * @param request
     * @return
     */
    User getLoginUser(HttpServletRequest request);

    /**
     * 用户注销
     * @param request
     * @return
     */
    boolean userLogout(HttpServletRequest request);

    UserVO getUserVO(User user);

    List<UserVO> getUserVOList(List<User> userList);

    QueryWrapper<User> getQueryWrapper(UserQueryRequest userQueryRequest);

}
