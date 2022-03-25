package com.example.ztianmusic.exception;

import cn.hutool.json.JSONUtil;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * description: 鉴权报错信息
 *
 * @author: zhangtian
 * @since: 2022-03-25 17:45
 */
@Component
public class RestAuthenticationEntryPoint implements AuthenticationEntryPoint {
    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Cache-Control","no-cache");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setCode(ExceptionType.UNAUTHORIZED.getCode());
        errorResponse.setMessage(ExceptionType.UNAUTHORIZED.getMessage());
        response.getWriter().println(JSONUtil.parse(errorResponse));
        response.getWriter().flush();
    }
}
