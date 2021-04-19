package com.example.wxchen.core.utils;
/**
 * 2021/4/7 16:27
 * 作者:wxchen
 * 描述:封装消息响应类
 */
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;

@Data
public class ResultMsg {
    private static ObjectMapper objectMapper = new ObjectMapper();
    public Integer code;
    public String msg;
    public Object data;

    public ResultMsg(Integer code,String msg,Object data){
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public static String success(Object data){
        try{
            return success(null,data);
        }catch (Exception e){
            return null;
        }
    }
     public static String success(String msg){
        try{
            return success(msg,null);
        }catch (Exception e){
            return null;
        }
     }
    public static String success(String msg,Object data) {
        try {
            return objectMapper.writeValueAsString(new ResultMsg(200,msg,data));
        } catch (Exception e) {
            return null;
        }
    }


    public static String success() {
        try {
            return success(null);
        } catch (Exception e) {
            return null;
        }
    }

    public static String success(int code, String msg) {
        try {
            return objectMapper.writeValueAsString(new ResultMsg(code,msg,null));
        } catch (Exception e) {
            return null;
        }
    }

    public static String fail(int code, String message) {
        try {
            return objectMapper.writeValueAsString(new ResultMsg(code, message, null));
        } catch (Exception e) {
            e.printStackTrace();
        }
        // 到这一步其实挺尴尬的
        return null;
    }

    public static String fail(String message) {
        try {
            // 通用错误返回
            return objectMapper.writeValueAsString(new ResultMsg(500, message, null));
        } catch (Exception e) {
            e.printStackTrace();
        }
        // 到这一步其实挺尴尬的
        return null;
    }

    public static String emptyList() {
        try {
            IPage<Object> result = new Page<>(1, 10, 0);
            return objectMapper.writeValueAsString(new ResultMsg(200, null, result));
        } catch (Exception e) {
            return null;
        }
    }
}
