package com.liu.pojo.dto;

/**
 * @author root
 * @create 2020-12-03 21:07
 */
public enum ResultEnum {
    UNKONW_ERROR(-1, "未知错误"),
    SUCCESS(0, "成功"),
    NOT_FOUND_BLOG(100, "博客不存在"),
    MIDDLE_SCHOOL(101, "你可能在上初中"),

    ;

    private Integer code;

    private String msg;

    ResultEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}