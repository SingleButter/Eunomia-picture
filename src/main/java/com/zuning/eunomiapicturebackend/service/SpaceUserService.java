package com.zuning.eunomiapicturebackend.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zuning.eunomiapicturebackend.model.dto.space.SpaceAddRequest;
import com.zuning.eunomiapicturebackend.model.dto.space.SpaceQueryRequest;
import com.zuning.eunomiapicturebackend.model.dto.spaceuser.SpaceUserAddRequest;
import com.zuning.eunomiapicturebackend.model.dto.spaceuser.SpaceUserQueryRequest;
import com.zuning.eunomiapicturebackend.model.entity.Space;
import com.zuning.eunomiapicturebackend.model.entity.SpaceUser;
import com.baomidou.mybatisplus.extension.service.IService;
import com.zuning.eunomiapicturebackend.model.entity.User;
import com.zuning.eunomiapicturebackend.model.vo.SpaceUserVO;
import com.zuning.eunomiapicturebackend.model.vo.SpaceVO;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
* @author wzuni
* @description 针对表【space_user(空间用户关联)】的数据库操作Service
* @createDate 2026-01-06 12:53:04
*/
public interface SpaceUserService extends IService<SpaceUser> {

    /**
     * 创建空间成员
     * @param spaceUserAddRequest
     * @return
     */
    long addSpaceUser(SpaceUserAddRequest spaceUserAddRequest);

    /**
     * 校验空间成员
     * @param spaceUser
     * @param add
     */
    void validSpaceUser(SpaceUser spaceUser, boolean add);

    /**
     * 获取空间成员包装类（单条）
     * @param spaceUser
     * @param request
     * @return
     */
    SpaceUserVO getSpaceUserVO(SpaceUser spaceUser, HttpServletRequest request);

    /**
     * 获取空间成员包装类（列表）
     * @param spaceUserList
     * @return
     */
    List<SpaceUserVO> getSpaceUserVOList(List<SpaceUser> spaceUserList);


    /**
     * 获取查询对象
     * @param spaceUserQueryRequest
     * @return
     */
    QueryWrapper<SpaceUser> getQueryWrapper(SpaceUserQueryRequest spaceUserQueryRequest);

}
