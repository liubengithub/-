package com.liu.utils;

import com.liu.pojo.dto.ResultDto;

/**
 * @author root
 * @create 2020-12-03 20:03
 */
public class ResultUtils {
    public static ResultDto success(Object object) {
        ResultDto result = new ResultDto();
        result.setCode(0);
        result.setMsg("成功");
        result.setData(object);
        return result;
    }

    public static ResultDto success() {
        return success(null);
    }

    public static ResultDto error(Integer code, String msg) {
        ResultDto result = new ResultDto();
        result.setCode(code);
        result.setMsg(msg);
        return result;
    }
}