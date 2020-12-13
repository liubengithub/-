package com.liu.pojo.dto;

/**
 * @author root
 * @create 2020-12-03 19:53
 * 创建统一的JSON返回对象，
 * code：消息类型，
 * message：消息内容，
 * url：请求的url，
 * data：请求返回的数据
 */
//返回参数封装类
/**
 * http请求返回的最外层对象
 * Created by wzh-zhua on 2018/10/1.
 */
public class ResultDto<T> {
    /** 错误码. */
    private Integer code;

    /** 提示信息. */
    private String msg;

    /** 具体的内容. */
    private T data;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

}