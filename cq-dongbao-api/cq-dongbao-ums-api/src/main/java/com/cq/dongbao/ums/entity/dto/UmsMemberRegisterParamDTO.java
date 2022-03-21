package com.cq.dongbao.ums.entity.dto;

import lombok.Data;
import lombok.ToString;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data
@ToString
public class UmsMemberRegisterParamDTO {

    @NotEmpty(message = "不能为空")
    @Size(min = 5, max = 10, message = "长度不合法")
    private String username;

    private String password;

    /**
     * 头像
     */
    private String icon;

    /**
     * 邮箱
     */
    @Email
    private String email;

    /**
     * 昵称
     */
    private String nickName;


}
