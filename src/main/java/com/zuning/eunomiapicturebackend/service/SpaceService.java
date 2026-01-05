package com.zuning.eunomiapicturebackend.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zuning.eunomiapicturebackend.model.dto.space.SpaceAddRequest;
import com.zuning.eunomiapicturebackend.model.dto.space.SpaceQueryRequest;
import com.zuning.eunomiapicturebackend.model.entity.Space;
import com.baomidou.mybatisplus.extension.service.IService;
import com.zuning.eunomiapicturebackend.model.entity.User;
import com.zuning.eunomiapicturebackend.model.vo.SpaceVO;

import javax.servlet.http.HttpServletRequest;

/**
* @author wzuni
* @description 针对表【space(空间)】的数据库操作Service
* @createDate 2025-12-28 15:36:23
*/
public interface SpaceService extends IService<Space> {

    /**
     * 校验空间
     *
     * @param space
     * @param add
     */
    void validSpace(Space space, boolean add);

    void fillSpaceBySpaceLevel(Space space);

    SpaceVO getSpaceVO(Space space, HttpServletRequest request);

    Page<SpaceVO> getSpaceVOPage(Page<Space> spacePage, HttpServletRequest request);

    QueryWrapper<Space> getQueryWrapper(SpaceQueryRequest spaceQueryRequest);

    long addSpace(SpaceAddRequest spaceAddRequest, User loginUser);
}
