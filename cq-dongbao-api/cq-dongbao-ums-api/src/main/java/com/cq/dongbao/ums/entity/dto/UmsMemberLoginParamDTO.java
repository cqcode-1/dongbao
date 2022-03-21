package com.cq.dongbao.ums.entity.dto;

import lombok.Data;
import lombok.ToString;
import org.springframework.lang.NonNull;
import org.springframework.lang.NonNullFields;

@Data
@ToString
public class UmsMemberLoginParamDTO {


    private String username;

    private String password;

}
