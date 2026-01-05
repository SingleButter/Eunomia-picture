package com.zuning.eunomiapicturebackend.controller;


import com.zuning.eunomiapicturebackend.common.BaseResponse;
import com.zuning.eunomiapicturebackend.common.ResultUtils;
import com.zuning.eunomiapicturebackend.exception.ErrorCode;
import com.zuning.eunomiapicturebackend.exception.ThrowUtils;
import com.zuning.eunomiapicturebackend.model.dto.space.analyze.SpaceUsageAnalyzeRequest;
import com.zuning.eunomiapicturebackend.model.entity.User;
import com.zuning.eunomiapicturebackend.model.vo.space.analyze.SpaceUsageAnalyzeResponse;
import com.zuning.eunomiapicturebackend.service.SpaceAnalyzeService;
import com.zuning.eunomiapicturebackend.service.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/space/analyze")
public class SpaceAnalyzeController {

    @Resource
    private SpaceAnalyzeService spaceAnalyzeService;

    @Resource
    private UserService userService;

    /**
     * 获取空间使用状态
     */
    @PostMapping("/usage")
    public BaseResponse<SpaceUsageAnalyzeResponse> getSpaceUsageAnalyze(
            @RequestBody SpaceUsageAnalyzeRequest spaceUsageAnalyzeRequest,
            HttpServletRequest request
    ) {
        ThrowUtils.throwIf(spaceUsageAnalyzeRequest == null, ErrorCode.PARAMS_ERROR);
        User loginUser = userService.getLoginUser(request);
        SpaceUsageAnalyzeResponse spaceUsageAnalyze = spaceAnalyzeService.getSpaceUsageAnalyze(spaceUsageAnalyzeRequest, loginUser);
        return ResultUtils.success(spaceUsageAnalyze);
    }
}

