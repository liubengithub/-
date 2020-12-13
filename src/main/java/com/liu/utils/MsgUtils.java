package com.liu.utils;

import java.util.HashMap;
import java.util.Map;

/**
 * @author root
 * @create 2020-12-05 15:59
 */
public class MsgUtils {
    //状态码 100-成功   200-失败
    private int code;
    //提示信息
    private String msg;
    //用户要返回给浏览器的数据
    private Map<String,Object> extend = new HashMap<String,Object>();
    public static MsgUtils success(){
        MsgUtils result = new MsgUtils();
        result.setCode(100);
        result.setMsg("处理成功！");
        return result;
    }
    public static MsgUtils fail(){
        MsgUtils result = new MsgUtils();
        result.setCode(200);
        result.setMsg("处理失败！");
        return result;
    }
    public MsgUtils add(String key, Object value){
        this.getExtend().put(key, value);
        return this;
    }
    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Map<String, Object> getExtend() {
        return extend;
    }

    public void setExtend(Map<String, Object> extend) {
        this.extend = extend;
    }
}
