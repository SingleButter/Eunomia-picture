package com.zuning.eunomiapicturebackend.model.dto.picture;

import lombok.Data;

import java.io.Serializable;

@Data
public class PictureReviewRequest implements Serializable {

    private static final long serialVersionUID = 2756012904280344551L;

    private Long id;

    private Integer reviewStatus;

    private String reviewMessage;
}
