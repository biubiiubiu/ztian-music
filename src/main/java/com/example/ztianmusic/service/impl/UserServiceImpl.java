package com.example.ztianmusic.service.impl;

import com.example.ztianmusic.dto.UserDto;
import com.example.ztianmusic.entity.User;
import com.example.ztianmusic.mapper.UserMapper;
import com.example.ztianmusic.repository.UserRepository;
import com.example.ztianmusic.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * description: User业务实现类
 *
 * @author: zhangtian
 * @since: 2022-03-23 22:45
 */
@Service
public class UserServiceImpl implements UserService {
    UserRepository userRepository;
    UserMapper userMapper;

    @Override
    public List<UserDto> list() {
        return userRepository.findAll().stream().map(userMapper::toDto).collect(Collectors.toList());
    }

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Autowired
    public void setUserMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }
}
