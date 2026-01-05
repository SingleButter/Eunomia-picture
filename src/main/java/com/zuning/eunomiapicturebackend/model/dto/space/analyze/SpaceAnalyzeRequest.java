package com.zuning.eunomiapicturebackend.model.dto.space.analyze;

import lombok.Data;

import java.io.Serializable;

@Data
public class SpaceAnalyzeRequest implements Serializable {

    /**
     * 空间ID
     */
    private Long spaceId;

    /**
     * 是否查询公共图库
     */
    private boolean queryPublic;

    /**
     * 是否为全空间分析
     */
    private boolean queryAll;


    private static final long serialVersionUID = 2796676773434521091L;
}
