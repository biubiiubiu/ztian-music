package com.example.ztianmusic.service;

import com.example.ztianmusic.dto.UserCreateRequest;
import com.example.ztianmusic.enums.Gender;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public abstract class BaseService {

    @Autowired
    UserService userService;

    @BeforeEach
    void setDefaultUser() {
        UserCreateRequest userCreateRequest = new UserCreateRequest();
        userCreateRequest.setUsername("xcsh005");
        userCreateRequest.setNickname("xcsh");
        userCreateRequest.setPassword("123456");
        userCreateRequest.setGender(Gender.MALE);
        userService.create(userCreateRequest);
    }
}
