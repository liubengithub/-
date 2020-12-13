package com.liu.handler;

import com.liu.exception.MyException;
import com.liu.pojo.dto.ResultDto;
import com.liu.utils.ResultUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * @author root
 * @create 2020-12-03 18:56
 */
@ControllerAdvice
public class ControllerExceptionHandler {
    private final static Logger logger = LoggerFactory.getLogger(ControllerExceptionHandler.class);

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public ResultDto handle(Exception e) {
        if (e instanceof MyException) {   //判断异常是否是我们定义的异常
            MyException myException = (MyException) e;
            return ResultUtils.error(myException.getCode(), myException.getMessage());
        }else {
            logger.error("【系统异常】{}", e);
            return ResultUtils.error(-1, "未知错误");
        }
    }
}
