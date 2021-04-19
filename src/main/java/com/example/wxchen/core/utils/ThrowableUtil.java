package com.wxchen.core.utils;

import java.io.PrintWriter;
import java.io.StringWriter;

/**
 * @Author wultn
 * @Description 异常工具
 * @Date 15:03 2020/12/9
 * @Param
 * @return
 **/
public class ThrowableUtil {

    /**
     * @Author wultn
     * @Description 获取堆栈信息
     * @Date 16:31 2020/11/30
     * @Param [throwable]
     * @return java.lang.String
     **/
    public static String getStackTrace(Throwable throwable){
        StringWriter sw = new StringWriter();
        try (PrintWriter pw = new PrintWriter(sw)) {
            throwable.printStackTrace(pw);
            return sw.toString();
        }
    }
}
