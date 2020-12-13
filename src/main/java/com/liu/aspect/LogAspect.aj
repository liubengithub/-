package com.liu.aspect;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

/**
 @author root
 @create 2020-12-04 10:42
 日志处理---针对发送请求前后，以及返回的数据
 */
@Aspect
@Component
//@Slf4j  // 等同于 private final Logger logger = LoggerFactory.getLogger(XXX.class);
public class LogAspect {
    private final Logger logger = LoggerFactory.getLogger(LogAspect.class);
    @Pointcut("execution(* com.liu.controller..*.*(..))")
    public void log(){ }
    @Before("log()")
    public void doBefore(JoinPoint joinPoint){
         logger.info("=================doBefore==================");
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        String requestURL = request.getRequestURL().toString();
        String remoteAddr = request.getRemoteAddr();
        String classMethod = joinPoint.getSignature().getDeclaringTypeName()+"."+joinPoint.getSignature().getName();
        Object[] args = joinPoint.getArgs();
        RequestLog requestLog = new RequestLog(requestURL,remoteAddr,classMethod,args);
        logger.info("Request : {}",requestLog);
    }
    @After("log()")
    public void doAfter(){
        logger.info("=================doAfter==================");
    }
    @AfterReturning(returning = "result",pointcut = "log()")
    public void doAfterReturning(Object result){
        logger.info("Result : {}",result);

    }
    private class RequestLog{
        private String requestUrl;
        private String ip;
        private String classMethod;
        private Object[] args;

        public RequestLog() {
        }

        public RequestLog(String requestUrl, String ip, String classMethod, Object[] args) {
            this.requestUrl = requestUrl;
            this.ip = ip;
            this.classMethod = classMethod;
            this.args = args;
        }

        public String getRequestUrl() {
            return requestUrl;
        }

        public void setRequestUrl(String requestUrl) {
            this.requestUrl = requestUrl;
        }

        public String getIp() {
            return ip;
        }

        public void setIp(String ip) {
            this.ip = ip;
        }

        public String getClassMethod() {
            return classMethod;
        }

        public void setClassMethod(String classMethod) {
            this.classMethod = classMethod;
        }

        public Object[] getArgs() {
            return args;
        }

        public void setArgs(Object[] args) {
            this.args = args;
        }

        @Override
        public String toString() {
            return "RequestLog{" +
                    "requestUrl='" + requestUrl + '\'' +
                    ", ip='" + ip + '\'' +
                    ", classMethod='" + classMethod + '\'' +
                    ", args=" + Arrays.toString(args) +
                    '}';
        }
    }
}
