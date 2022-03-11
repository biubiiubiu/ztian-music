package com.example.ztianmusic.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * description: 临时测试连通性
 *
 * @author: zhangtian
 * @since: 2022-03-08 13:11
 */
@CrossOrigin
@RestController
@RequestMapping("/hello")
public class DefaultController {
    @GetMapping
    public String sayHello(){
        return "你好，欢迎来到ZtianMusic";
    }
}
