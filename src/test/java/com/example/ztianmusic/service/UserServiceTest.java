package com.example.ztianmusic.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserServiceTest {
    PasswordEncoder passwordEncoder;
    @Test
    void getCurrentUser() {
    }

    @Test
    void getPassword() {
        String password = "123456";
        System.out.println(passwordEncoder.encode(password));
    }

    @Autowired
    private void setPasswordEncoder(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }
}