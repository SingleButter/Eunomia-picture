package com.zuning.eunomiapicturebackend.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.zuning.eunomiapicturebackend.model.dto.picture.PictureQueryRequest;
import com.zuning.eunomiapicturebackend.model.dto.picture.PictureUploadRequest;
import com.zuning.eunomiapicturebackend.model.entity.Picture;
import com.zuning.eunomiapicturebackend.model.entity.User;
import com.zuning.eunomiapicturebackend.model.vo.PictureVO;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

/**
* @author wzuni
* @description 针对表【picture(图片)】的数据库操作Service
* @createDate 2025-11-13 14:48:44
*/
public interface PictureService extends IService<Picture> {

    /**
     * 上传图片
     *
     * @param multipartFile
     * @param pictureUploadRequest
     * @param loginUser
     * @return
     */
    PictureVO uploadPicture(MultipartFile multipartFile,
                            PictureUploadRequest pictureUploadRequest,
                            User loginUser);

    QueryWrapper<Picture> getQueryWrapper(PictureQueryRequest pictureQueryRequest);

    PictureVO getPictureVO(Picture picture, HttpServletRequest request);

    Page<PictureVO> getPictureVOPage(Page<Picture> picturePage, HttpServletRequest request);

    void validPicture(Picture picture);

}
