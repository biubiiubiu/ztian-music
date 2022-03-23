package com.example.ztianmusic.repository;

import com.example.ztianmusic.entity.User;
import com.example.ztianmusic.enums.Gender;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserRepositoryTest {

    @Autowired
    UserRepository repository;

    @Test
    void findByUsername(){
        User user = new User();
        user.setUsername("zt");
        user.setNickname("zt001");
        user.setEnabled(true);
        user.setLocked(false);
        user.setGender(Gender.MALE);
        user.setPassword("123456");
        user.setLastLoginIp("localhost");
        user.setLastLoginTime(new Date());

        // 对象存入数据库
        User saveUser = repository.save(user);
        // jpa特性，在repository中自定义查询方法，简单调用
        User zt = repository.getByUsername("zt");

        System.out.println(zt);
    }


}