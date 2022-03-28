package com.example.ztianmusic.service;

import com.example.ztianmusic.dto.UserCreateRequest;
import com.example.ztianmusic.dto.UserDto;
import com.example.ztianmusic.dto.UserUpdateRequest;
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
    List<UserDto> list();

    UserDto create(UserCreateRequest createDto);


    UserDto get(String id);

    UserDto update(String id, UserUpdateRequest userUpdateRequest);

    void delete(String id);

    Page<UserDto> search(Pageable pageable);
}
