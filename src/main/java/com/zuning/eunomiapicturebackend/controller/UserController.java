package com.zuning.eunomiapicturebackend.controller;

import com.zuning.eunomiapicturebackend.common.BaseResponse;
import com.zuning.eunomiapicturebackend.common.ResultUtils;
import com.zuning.eunomiapicturebackend.exception.ErrorCode;
import com.zuning.eunomiapicturebackend.exception.ThrowUtils;
import com.zuning.eunomiapicturebackend.model.dto.UserLoginRequest;
import com.zuning.eunomiapicturebackend.model.dto.UserRegisterRequest;
import com.zuning.eunomiapicturebackend.model.entity.User;
import com.zuning.eunomiapicturebackend.model.vo.LoginUserVO;
import com.zuning.eunomiapicturebackend.service.UserService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;


@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserService userService;

    @PostMapping("/register")
    public BaseResponse<Long> userRegister(@RequestBody UserRegisterRequest userRegisterRequest) {
        ThrowUtils.throwIf(userRegisterRequest == null, ErrorCode.PARAMS_ERROR);
        long result = userService.userRegister(userRegisterRequest);
        return ResultUtils.success(result);
    }

    @PostMapping("/login")
    public BaseResponse<LoginUserVO> userLogin(@RequestBody UserLoginRequest userLoginRequest, HttpServletRequest request) {
        ThrowUtils.throwIf(userLoginRequest == null, ErrorCode.PARAMS_ERROR);
        LoginUserVO result = userService.userLogin(userLoginRequest, request);
        return ResultUtils.success(result);
    }

    @GetMapping("/get/login")
    public BaseResponse<LoginUserVO> getLoginUser(HttpServletRequest request) {
        User loginUser = userService.getLoginUser(request);
        return ResultUtils.success(userService.getLoginUserVO(loginUser));
    }

    @PostMapping("/logout")
    public BaseResponse<Boolean> userLogout(HttpServletRequest request) {
        ThrowUtils.throwIf(request == null, ErrorCode.PARAMS_ERROR);
        boolean result = userService.userLogout(request);
        return ResultUtils.success(result);
    }




}
