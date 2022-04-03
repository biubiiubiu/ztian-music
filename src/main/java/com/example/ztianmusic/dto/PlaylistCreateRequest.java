package com.example.ztianmusic.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * description:
 *
 * @author: zhangtian
 * @since: 2022-04-01 22:29
 */
@Data
public class PlaylistCreateRequest {
    @NotBlank(message = "歌单名不能为空")
    private String name;

    private String description;

    @NotNull(message = "请上传封面")
    private String coverId;
}

