package com.example.ztianmusic.mapper;

import com.example.ztianmusic.dto.UserDto;
import com.example.ztianmusic.entity.User;
import com.example.ztianmusic.vo.UserVo;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

/**
 * description: usermapper
 *
 * @author: zhangtian
 * @since: 2022-03-23 22:42
 */
@Mapper(componentModel = "spring")
@Component
public interface UserMapper {
    UserDto toDto(User user);

    UserVo toVo(UserDto userDto);

//    User createEntity(UserCreateRequest userCreateRequest);
//
//    User updateEntity(@MappingTarget User user, UserUpdateRequest userUpdateRequest);
}
