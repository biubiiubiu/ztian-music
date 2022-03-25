package com.example.ztianmusic.service.impl;

import com.example.ztianmusic.dto.UserCreateDto;
import com.example.ztianmusic.dto.UserDto;
import com.example.ztianmusic.entity.User;
import com.example.ztianmusic.exception.BizException;
import com.example.ztianmusic.exception.ExceptionType;
import com.example.ztianmusic.mapper.UserMapper;
import com.example.ztianmusic.repository.UserRepository;
import com.example.ztianmusic.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
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
    PasswordEncoder passwordEncoder;

    @Override
    public List<UserDto> list() {
        return userRepository.findAll().stream().map(userMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public UserDto create(UserCreateDto createDto) {
        checkUserName(createDto.getUsername());
        User entity = userMapper.createEntity(createDto);
        entity.setPassword(passwordEncoder.encode(entity.getPassword()));
        return userMapper.toDto(userRepository.save(entity));
    }

    private void checkUserName(String username) {
        Optional<User> user = userRepository.findByUsername(username);
        if (user.isPresent()) {
            throw new BizException(ExceptionType.USER_NAME_DUPLICATE);
        }
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = userRepository.findByUsername(username);
        if (!user.isPresent()) {
            throw new BizException(ExceptionType.USER_NOT_FOUND);
        }
        return user.get();
    }

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Autowired
    public void setUserMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Autowired
    public void setPasswordEncoder(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }


}
