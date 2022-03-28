package com.example.ztianmusic.config;

import com.example.ztianmusic.exception.RestAuthenticationEntryPoint;
import com.example.ztianmusic.filter.JwtAuthenticationFilter;
import com.example.ztianmusic.filter.JwtAuthorizationFilter;
import com.example.ztianmusic.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;

/**
 * description: 鉴权配置
 *
 * @author: zhangtian
 * @since: 2022-03-25 17:02
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    // 密钥
    public static final String SECRET = "ZtianMusic";
    // 过期时间，10days
    public static final long EXPIRATION_TIME = 864000000;
    // 前缀
    public static final String TOKEN_PREFIX = "Bearer ";
    // 变量名
    public static final String HEADER_STRING = "Authorization";
    // 鉴权注册入口
    public static final String SIGN_UP_URL = "/users/";

    UserService userService;

    RestAuthenticationEntryPoint restAuthenticationEntryPoint;

    /**
     * 过滤配置
     * @Param: httpsecurity
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.cors().and().csrf().disable()  // 开启跨域请求、关闭csrf验证
                .authorizeRequests()
//                .antMatchers(HttpMethod.POST, SIGN_UP_URL).permitAll()  // 允许所有人请求
                .anyRequest().authenticated()   // 其它请求必须鉴权后才能请求
                .and()
                .addFilter(new JwtAuthenticationFilter(authenticationManager()))    // 先用户名密码鉴权
                .addFilter(new JwtAuthorizationFilter(authenticationManager()))     // 再token鉴权
                .exceptionHandling()
                .authenticationEntryPoint(restAuthenticationEntryPoint)     // 403 404等报错信息
                .and()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);    // 设置为无状态的session
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        // 调用loadUserByUsername方法时读取此userService的username
        auth.userDetailsService(userService);
    }

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Autowired
    public void setRestAuthenticationEntryPoint(RestAuthenticationEntryPoint restAuthenticationEntryPoint) {
        this.restAuthenticationEntryPoint = restAuthenticationEntryPoint;
    }
}
