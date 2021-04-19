package com.example.wxchen.core.exception;

import com.example.wxchen.core.utils.ResultMsg;
import com.example.wxchen.core.exception.AdviceException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 统一异常处理
 *
 * @Author: ght
 * @Date: 2020/12/9
 */
@RestControllerAdvice
public class ExceptionResolver {

    @ExceptionHandler(AdviceException.class)
    public String handleAdviceException(AdviceException e) {
        return ResultMsg.fail(e.getCode(), e.getMessage());
    }
}
