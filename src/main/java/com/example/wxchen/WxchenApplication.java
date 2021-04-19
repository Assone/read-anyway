package com.example.wxchen;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//@SpringBootApplication：标注这个类是一个springboot应用
@MapperScan("com.example.wxchen.api.mapper")
@SpringBootApplication
public class WxchenApplication {

    public static void main(String[] args) {
        //将springboot应用启动
        SpringApplication.run(WxchenApplication.class, args);
    }

}
