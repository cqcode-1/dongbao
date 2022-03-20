package com.cq.dongbao.ums.entity.vo;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class UmsMemberRegisterParamDTO {

    private String username;

    private String password;

    /**
     * 头像
     */
    private String icon;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 昵称
     */
    private String nickName;


}
