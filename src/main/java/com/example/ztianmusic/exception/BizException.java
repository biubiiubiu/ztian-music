package com.example.ztianmusic.exception;

/**
 * description: 全局异常
 *
 * @author: zhangtian
 * @since: 2022-03-25 10:07
 */
public class BizException extends RuntimeException{
    private final Integer code;

    public BizException(ExceptionType exceptionType) {
        super(exceptionType.getMessage());
        this.code = exceptionType.getCode();
    }

    public Integer getCode() {
        return code;
    }
}
