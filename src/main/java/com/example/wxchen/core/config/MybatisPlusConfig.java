package com.example.wxchen.core.config;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author ght
 * @Date 2020/12/6 20:19
 */
@Configuration
@MapperScan("com.wxchen.api.**.mapper*")
public class MybatisPlusConfig {
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        return new PaginationInterceptor().setLimit(-1);
    }
}
