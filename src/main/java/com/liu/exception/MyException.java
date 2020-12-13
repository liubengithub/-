package com.liu.exception;

import com.liu.pojo.dto.ResultEnum;

/**
 * @author root
 * @create 2020-12-03 20:59
 */
public class MyException extends RuntimeException{
    //注意：spring中，只有RuntimeException才会进行事务回滚，Exception不会进行事务回滚
    private Integer code;

    public MyException(ResultEnum resultEnum) {
        super(resultEnum.getMsg());
        this.code = resultEnum.getCode();
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
