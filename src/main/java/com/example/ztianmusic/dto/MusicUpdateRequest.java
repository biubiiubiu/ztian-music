package com.example.ztianmusic.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.util.List;

/**
 * description: 音乐上传约束类
 *
 * @author: zhangtian
 * @since: 2022-03-28 16:21
 */
@Data
public class MusicUpdateRequest {
    @NotBlank(message = "歌曲名不能为空")
    private String name;

    private String description;

    private String fileId;

    @NotEmpty(message = "歌手未选择")
    private List<String> artistIds;
}

