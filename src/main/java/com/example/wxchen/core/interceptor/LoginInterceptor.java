package com.example.wxchen.core.interceptor;

import com.example.wxchen.core.exception.AdviceException;
import com.example.wxchen.core.utils.Constants;
import com.example.wxchen.core.utils.SecurityService;
import com.example.wxchen.api.entity.User;
import org.apache.tomcat.util.buf.MessageBytes;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Field;
import java.util.*;

/**
 * 登录拦截器
 * @Author: ght
 * @Date: 2020/12/7
 */
@Component
public class LoginInterceptor implements HandlerInterceptor {

    private final List<String> whiteList =
            new ArrayList<String>() {
                private static final long serialVersionUID = -783515679938182281L;
                {
                    add("/user/login");
                    add("/customerInformation/saveInfo");
                }
            };
    private boolean checkWhiteList(String uri) {
        for (String white : whiteList) {
            if (uri.contains(white)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean preHandle(HttpServletRequest req, HttpServletResponse resp, Object handler) throws Exception {

        String requestURI = req.getRequestURI();
        if ("/error".equals(requestURI)) {
            Object a = findCoyoteRequest(req);
            Field coyoteRequest = a.getClass().getDeclaredField("coyoteRequest");
            coyoteRequest.setAccessible(true);
            Object b = coyoteRequest.get(a);

            Field uriMB = b.getClass().getDeclaredField("uriMB");
            uriMB.setAccessible(true);
            MessageBytes c = (MessageBytes)uriMB.get(b);
            System.out.println(c.getString());
            requestURI = c.getString();
        }
        // 登录请求不做拦截
        if (checkWhiteList(requestURI)) {
            return true;
        } else {
            User currentUser = SecurityService.getCurrentUser();
            if (null==currentUser) {
                throw new AdviceException(Constants.USER_NOT_LOGIN,"当前未登录,请登录!");
            }
            return true;
        }
    }

    private Class getClassByName(Class classObject, String name){
        Map<Class,List<Field>> fieldMap = new HashMap<>();
        Class returnClass = null;
        Class tempClass = classObject;
        while (tempClass != null) {
            fieldMap.put(tempClass, Arrays.asList(tempClass .getDeclaredFields()));
            tempClass = tempClass.getSuperclass();
        }

        for(Map.Entry<Class,List<Field>> entry: fieldMap.entrySet()){
            for (Field f : entry.getValue()) {
                if(f.getName().equals(name)){
                    returnClass = entry.getKey();
                    break;
                }
            }
        }
        return returnClass;
    }

    private Object findCoyoteRequest(Object request)  throws Exception {
        Class a = getClassByName(request.getClass(),"request");
        Field request1 = a.getDeclaredField("request");
        request1.setAccessible(true);
        Object b = request1.get(request);
        if(getClassByName(b.getClass(),"coyoteRequest") == null){
            return findCoyoteRequest(b);
        }else{
            return b;
        }
    }
}
