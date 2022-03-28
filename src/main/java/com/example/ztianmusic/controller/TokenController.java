package com.example.ztianmusic.controller;

import com.example.ztianmusic.dto.TokenCreateRequest;
import com.example.ztianmusic.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }
}
