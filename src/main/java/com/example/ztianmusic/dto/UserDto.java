package com.example.ztianmusic.dto;

import com.example.ztianmusic.enums.Gender;
import com.example.ztianmusic.vo.RoleVo;
import lombok.Data;

import java.util.List;

/**
 * description: 转换模型
 *
 * @author: zhangtian
 * @since: 2022-03-23 22:38
 */
@Data
public class UserDto {
    private String id;

    private String username;

    private String nickname;

    private Gender gender;

    private Boolean locked;

    private Boolean enabled;

    private String openId;

    private List<RoleVo> roles;
}
