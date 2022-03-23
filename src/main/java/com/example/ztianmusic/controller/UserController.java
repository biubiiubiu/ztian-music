package com.example.ztianmusic.controller;

import com.example.ztianmusic.mapper.UserMapper;
import com.example.ztianmusic.service.UserService;
import com.example.ztianmusic.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

/**
 * description: user controller
 *
 * @author: zhangtian
 * @since: 2022-03-23 22:25
 */
@RestController
@RequestMapping("/users")
public class UserController {
    UserService userService;
    UserMapper userMapper;

    @GetMapping("/")
    List<UserVo> list() {
        return userService.list().stream().map(userMapper::toVo).collect(Collectors.toList());
    }

    // 调用时会注入，比直接在成员上加注解要优
    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Autowired
    public void setUserMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }
}
