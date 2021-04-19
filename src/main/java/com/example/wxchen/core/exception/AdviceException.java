package com.example.wxchen.core.exception;

/**
 * 自定义异常
 *
 * @Author: ght
 * @Date: 2020/12/9
 */
public class AdviceException extends RuntimeException {

    private int code;

    public AdviceException(int code) {
        this.code = code;
    }

    public AdviceException(String message) {
        super(message);
    }

    public AdviceException(int code, String message) {
        super(message);
        this.code = code;
    }

    public AdviceException(String message, Throwable cause, int code) {
        super(message, cause);
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
