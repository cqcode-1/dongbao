package com.cq.dongbao.common.result;

import com.cq.dongbao.common.enums.StateCodeEnum;
import lombok.Builder;
import lombok.Data;

@Data
@Builder  //用于链式调用构造对象
public class ResultWarpper<T> {

    Integer code;
    String message;
    T data;

    public static ResultWarpper getSuccess(){
        return ResultWarpper.builder().code(StateCodeEnum.SUCCESS.getCode()).message(StateCodeEnum.SUCCESS.getMessage()).build();
    }

    public static ResultWarpper getFailed(){
        return ResultWarpper.builder().code(StateCodeEnum.FAILED.getCode()).message(StateCodeEnum.FAILED.getMessage()).build();
    }
}
