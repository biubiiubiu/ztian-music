package com.example.ztianmusic.service;

import com.example.ztianmusic.dto.UserCreateDto;
import com.example.ztianmusic.dto.UserDto;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

/**
 * description: User业务接口
 *
 * @author: zhangtian
 * @since: 2022-03-23 22:45
 */
public interface UserService extends UserDetailsService {
    List<UserDto> list();

    UserDto create(UserCreateDto createDto);
}
