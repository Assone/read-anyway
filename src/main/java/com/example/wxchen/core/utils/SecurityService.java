package com.example.wxchen.core.utils;


import com.example.wxchen.api.entity.User;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;

/**
 * @Author: ght
 * @Date: 2020/12/7
 */
@Service
public class SecurityService {

    private final HttpServletRequest requestValue;
    private static HttpServletRequest request;

    public SecurityService(HttpServletRequest requestValue) {
        this.requestValue = requestValue;
    }

    @PostConstruct
    public void init() {
        request = requestValue;
    }

    /**
     * 获取当前登录用户
     */
    public static User getCurrentUser() {
        return (User) request.getSession().getAttribute(com.example.wxchen.core.utils.Constants.SESSION_KEY);
    }
}
