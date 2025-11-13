package com.zuning.eunomiapicturebackend.model.dto.user;

import lombok.Data;

import java.io.Serializable;

@Data
public class UserLoginRequest implements Serializable {


    private static final long serialVersionUID = -7682458354521479563L;

    private String userAccount;

    private String userPassword;
}
