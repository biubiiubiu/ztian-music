package com.example.ztianmusic.filter;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.example.ztianmusic.config.SecurityConfig;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

/**
 * description: Jwt授权过滤器
 *
 * @author: zhangtian
 * @since: 2022-03-25 17:20
 */
public class JwtAuthorizationFilter extends BasicAuthenticationFilter {

    public JwtAuthorizationFilter(AuthenticationManager authenticationManager) {
        super(authenticationManager);
    }

    /**
     * 从header中鉴别token，如果有token就鉴权，鉴权成功就写入上下文
     * @Param: http请求
     */
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
        String header = request.getHeader(SecurityConfig.HEADER_STRING);

        if (header == null || !header.startsWith(SecurityConfig.TOKEN_PREFIX)) {
            chain.doFilter(request, response);
            return;
        }
        // 验证token
        UsernamePasswordAuthenticationToken authenticationToken = getAuthentication(header);
        // 把token写入上下文
        SecurityContextHolder.getContext().setAuthentication(authenticationToken);
        // 继续chain的filter执行
        chain.doFilter(request, response);
    }

    /**
     * 用于验证token是否生效
     * @Param: header
     * @return: password的token
     */
    private UsernamePasswordAuthenticationToken getAuthentication(String header) {
        if (header != null) {
            String username = JWT.require(Algorithm.HMAC512(SecurityConfig.SECRET.getBytes()))
                    .build()
                    .verify(header.replace(SecurityConfig.TOKEN_PREFIX, ""))
                    .getSubject();
            if (username != null) {
                return new UsernamePasswordAuthenticationToken(username, null, new ArrayList<>());
            }
        }
        return null;
    }
}
