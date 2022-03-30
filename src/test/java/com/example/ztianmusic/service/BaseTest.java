package com.example.ztianmusic.service;

import com.example.ztianmusic.dto.UserCreateRequest;
import com.example.ztianmusic.dto.UserDto;
import com.example.ztianmusic.entity.User;
import com.example.ztianmusic.enums.Gender;
import com.example.ztianmusic.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public abstract class BaseTest {

    @Autowired
    UserService userService;

    @Autowired
    UserRepository userRepository;

    @BeforeEach
    void setDefaultUser() {
        UserCreateRequest userCreateRequest = new UserCreateRequest();
        userCreateRequest.setUsername("ztian");
        userCreateRequest.setNickname("ztian");
        userCreateRequest.setPassword("123456");
        userCreateRequest.setGender(Gender.MALE);
        UserDto userDto = userService.create(userCreateRequest);

        User user = userService.loadUserByUsername(userDto.getUsername());
        user.setOpenId("ztian-openid");
        userRepository.save(user);
    }
}

