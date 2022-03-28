package com.example.ztianmusic.controller;

import com.example.ztianmusic.dto.UserCreateRequest;
import com.example.ztianmusic.dto.UserUpdateRequest;
import com.example.ztianmusic.mapper.UserMapper;
import com.example.ztianmusic.service.UserService;
import com.example.ztianmusic.vo.UserVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * description: user controller
 *
 * @author: zhangtian
 * @since: 2022-03-23 22:25
 */
@RestController
@RequestMapping("/users")
@Api(tags = "用户")
public class UserController {
    UserService userService;
    UserMapper userMapper;

    @GetMapping("/")
    @ApiOperation("用户检索")
    Page<UserVo> search(@PageableDefault(sort = {"createdTime"}, direction = Sort.Direction.ASC) Pageable pageable) {
        return userService.search(pageable).map(userMapper::toVo);
    }

    @PostMapping()
    UserVo create(@Validated @RequestBody UserCreateRequest userCreateRequest) {
        return userMapper.toVo(userService.create(userCreateRequest));
    }

    @GetMapping("/{id}")
    UserVo get(@PathVariable String id) {
        return userMapper.toVo(userService.get(id));
    }

    @PutMapping("/{id}")
    UserVo update(@PathVariable String id,
                  @Validated @RequestBody UserUpdateRequest userUpdateRequest) {
        return userMapper.toVo(userService.update(id, userUpdateRequest));
    }

    @DeleteMapping("/{id}")
    void delete(@PathVariable String id) {
        userService.delete(id);
    }

    @GetMapping("/me")
    UserVo me() {
        return userMapper.toVo(userService.getCurrentUser());
    }

    // 调用时会注入，比直接在成员上加注解要优
    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Autowired
    public void setUserMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }
}
