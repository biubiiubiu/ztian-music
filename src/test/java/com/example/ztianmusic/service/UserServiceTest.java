package com.example.ztianmusic.service;

import com.example.ztianmusic.dto.UserDto;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootTest
@Slf4j
class UserServiceTest extends BaseTest {

    @Autowired
    UserService userService;

    PasswordEncoder passwordEncoder;
    @Test
    void getCurrentUser() {
    }

    @Test
    void getPassword() {
        String password = "123456";
        // 这个每天都不一样
        System.out.println(passwordEncoder.encode(password));
    }

//    @Test
//    void getById() {
//        UserDto admin = userService.get("1");
//        log.info(admin.getUsername());
//    }
//
//    @Test
//    void getByUsernameTest() {
//        UserDto admin = userService.getByUsername("admin");
//        log.info(admin.getUsername());
//    }

    @Autowired
    private void setPasswordEncoder(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }
}