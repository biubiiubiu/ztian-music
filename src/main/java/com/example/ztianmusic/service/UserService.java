package com.example.ztianmusic.service;

import com.example.ztianmusic.dto.TokenCreateRequest;
import com.example.ztianmusic.dto.UserCreateRequest;
import com.example.ztianmusic.dto.UserDto;
import com.example.ztianmusic.dto.UserUpdateRequest;
import com.example.ztianmusic.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

/**
 * description: User业务接口
 *
 * @author: zhangtian
 * @since: 2022-03-23 22:45
 */
public interface UserService extends UserDetailsService {
    UserDto create(UserCreateRequest userCreateRequest);

    @Override
    User loadUserByUsername(String username);

    UserDto get(String id);

    UserDto update(String id, UserUpdateRequest userUpdateRequest);

    void delete(String id);

    Page<UserDto> search(Pageable pageable);

    String createToken(TokenCreateRequest tokenCreateRequest);

    UserDto getCurrentUser();

    String createTokenByOpenId(String openId);
}
