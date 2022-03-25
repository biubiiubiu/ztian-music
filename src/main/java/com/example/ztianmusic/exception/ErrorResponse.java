package com.example.ztianmusic.exception;

import lombok.Data;

/**
 * description: 错误信息
 *
 * @author: zhangtian
 * @since: 2022-03-25 10:17
 */
@Data
public class ErrorResponse {
    private Integer code;
    private String message;
    private Object trace;
}
