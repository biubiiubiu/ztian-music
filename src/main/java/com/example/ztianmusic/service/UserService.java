package com.example.ztianmusic.service;

import com.example.ztianmusic.dto.UserDto;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * description: User业务接口
 *
 * @author: zhangtian
 * @since: 2022-03-23 22:45
 */
public interface UserService {
    List<UserDto> list();
}
