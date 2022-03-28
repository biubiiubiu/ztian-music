//package com.example.ztianmusic.filter;
//
//import com.auth0.jwt.JWT;
//import com.auth0.jwt.algorithms.Algorithm;
//import com.example.ztianmusic.config.SecurityConfig;
//import com.example.ztianmusic.entity.User;
//import com.example.ztianmusic.exception.BizException;
//import com.example.ztianmusic.exception.ExceptionType;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.AuthenticationException;
//import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
//
//import javax.servlet.FilterChain;
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.Date;
//
///**
// * description: Jwt鉴权过滤器
// *
// * @author: zhangtian
// * @since: 2022-03-25 17:08
// */
//public class JwtAuthenticationFilter extends UsernamePasswordAuthenticationFilter {
//    private final AuthenticationManager authenticationManager;
//
//    public JwtAuthenticationFilter(AuthenticationManager authenticationManager) {
//        this.authenticationManager = authenticationManager;
//    }
//
//    /**
//     * 从请求里获取用户信息，生成鉴权token
//     * @Param: http请求
//     * @return: 用户名密码鉴权后的token
//     */
//    @Override
//    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
//        try {
//            User user =  new ObjectMapper()
//                    .readValue(request.getInputStream(), User.class);
//            return authenticationManager.authenticate(
//                    new UsernamePasswordAuthenticationToken(
//                            user.getUsername(),
//                            user.getPassword(),
//                            new ArrayList<>()
//                    )
//            );
//        } catch (IOException e) {
//            throw new BizException(ExceptionType.FORBIDDEN);
//        }
//    }
//
//    /**
//     * 生成token（username作为主题、设置过期时间、hma512算法生成签名）并放在header中，表示鉴权成功
//     * @Param: http请求等信息
//     */
//    @Override
//    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult) throws IOException, ServletException {
//        String token = JWT.create()
//                .withSubject(((User)authResult.getPrincipal()).getUsername())
//                .withExpiresAt(new Date(System.currentTimeMillis() + SecurityConfig.EXPIRATION_TIME))
//                .sign(Algorithm.HMAC512(SecurityConfig.SECRET.getBytes()));
//        response.addHeader(SecurityConfig.HEADER_STRING, SecurityConfig.TOKEN_PREFIX + token);
//    }
//}
