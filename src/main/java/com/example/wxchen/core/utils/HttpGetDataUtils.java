package com.example.wxchen.core.utils;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;

public class HttpGetDataUtils {
    /**
     * @Author wultn
     * @Description 获取数据
     * @Date 10:51 2019/4/25
     * @Param [api]
     **/
    public static String getData(String api){
        StringBuilder res = new StringBuilder();
        try {
            URL url = new URL(api);
            HttpURLConnection conn = (HttpURLConnection)url.openConnection();
            conn.setDoOutput(true);
            conn.setRequestMethod("GET");
            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream(), StandardCharsets.UTF_8));
            String line;
            while ((line = in.readLine()) != null) {
                res.append(line).append("\n");
            }
            in.close();
        } catch (Exception e) {
            System.out.println("error in wapaction,and e is " + e.getMessage());
            return ResultMsg.fail("http请求获取数据失败！");
        }
        return res.toString();
    }
}
