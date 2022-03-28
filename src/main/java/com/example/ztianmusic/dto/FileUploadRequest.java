package com.example.ztianmusic.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * description: 文件上传约束
 *
 * @author: zhangtian
 * @since: 2022-03-28 16:33
 */
@Data
public class FileUploadRequest {

    @NotBlank(message = "文件名不能为空")
    private String name;

    private Integer size;

    @NotBlank(message = "后缀名不能为空")
    private String ext;

    @NotBlank(message = "key不能为空")
    private String key;
}

