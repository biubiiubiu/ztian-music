package com.example.ztianmusic.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

/**
 * description: 用户数据修改字段时约束
 *
 * @author: zhangtian
 * @since: 2022-03-28 08:37
 */
@Data
public class UserUpdateRequest {

    @NotBlank(message = "用户名不能为空")
    @Size(min = 4, max = 64, message = "用户名长度应该在4个字符到64个字符之间")
    private String username;

    private String nickname;

    private String gender;
}
