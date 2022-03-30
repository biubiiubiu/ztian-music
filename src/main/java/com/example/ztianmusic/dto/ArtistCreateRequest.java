package com.example.ztianmusic.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * description:
 *
 * @author: zhangtian
 * @since: 2022-03-30 09:34
 */
@Data
public class ArtistCreateRequest {

    @NotBlank(message = "歌手名字不能为空")
    private String name;

    private String remark;

    @NotBlank(message = "歌手照片必须上传")
    private String photoId;
}
