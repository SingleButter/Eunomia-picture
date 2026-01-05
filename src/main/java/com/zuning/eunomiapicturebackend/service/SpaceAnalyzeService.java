package com.zuning.eunomiapicturebackend.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zuning.eunomiapicturebackend.model.dto.space.analyze.SpaceUsageAnalyzeRequest;
import com.zuning.eunomiapicturebackend.model.entity.Space;
import com.zuning.eunomiapicturebackend.model.entity.User;
import com.zuning.eunomiapicturebackend.model.vo.space.analyze.SpaceUsageAnalyzeResponse;

public interface SpaceAnalyzeService extends IService<Space> {
    /**
     * 获取空间使用情况分析
     * @param spaceUsageAnalyzeRequest
     * @param loginUser
     * @return
     */
    SpaceUsageAnalyzeResponse getSpaceUsageAnalyze(SpaceUsageAnalyzeRequest spaceUsageAnalyzeRequest, User loginUser);
}
