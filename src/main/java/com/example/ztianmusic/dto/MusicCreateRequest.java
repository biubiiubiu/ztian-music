package com.example.ztianmusic.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * description: 音乐创建约束类
 *
 * @author: zhangtian
 * @since: 2022-03-28 16:22
 */
@Data
public class MusicCreateRequest {

    @NotBlank(message = "歌曲名不能为空")
    private String name;

    private String description;
}