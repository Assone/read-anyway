package com.example.wxchen.core.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration//标记配置类
@EnableSwagger2//开启在线接口文档
public class Swagger2Config implements WebMvcConfigurer {

    @Bean
    public Docket controllerApi(){

        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(new ApiInfoBuilder()
                    .title("readAnyway APi Demo_接口文档")
                    .description("这是一个demo的后台服务")
                    .contact(new Contact("wxchen","https://gitee.com/wxchenkk","Wxc990824@163.com"))
                    .version("版本号：1.0.0")
                    .build())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.example.wxchen.api.controller"))
                .paths(PathSelectors.any())
                .build();
    }

}
