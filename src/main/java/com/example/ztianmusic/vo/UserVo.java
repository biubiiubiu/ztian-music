package com.example.ztianmusic.vo;

import com.example.ztianmusic.enums.Gender;
import lombok.Data;

import java.util.List;

/**
 * description: user values object类
 *
 * @author: zhangtian
 * @since: 2022-03-23 22:28
 */
@Data
public class UserVo {
    private String id;

    private String username;

    private String nickname;

    private Gender gender;

    private Boolean locked;

    private Boolean enabled;

    private List<RoleVo> roles;
}
