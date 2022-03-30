package com.example.ztianmusic.controller;

import com.example.ztianmusic.dto.TokenCreateRequest;
import com.example.ztianmusic.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * description: token controller
 *
 * @author: zhangtian
 * @since: 2022-03-28 08:59
 */
@RestController
@RequestMapping("/tokens")
public class TokenController {
    UserService userService;

    @PostMapping
    public String create(@RequestBody TokenCreateRequest tokenCreateRequest) {
        return userService.createToken(tokenCreateRequest);
    }

    @PostMapping("/mp")
    public String createByMp(@RequestHeader(name = "X-WX-OPENID") String openId) {
        return userService.createTokenByOpenId(openId);
    }

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }
}
