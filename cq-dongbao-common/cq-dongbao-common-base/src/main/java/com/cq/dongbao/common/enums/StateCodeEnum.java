package com.cq.dongbao.common.enums;

public enum StateCodeEnum {

    SUCCESS(0, "请求成功！"),

    FAILED(-1, "请求失败");

    private Integer code;

    private String message;

    StateCodeEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
