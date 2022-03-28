package com.example.ztianmusic.dto;

import lombok.Data;

/**
 * description: 文件上传dto
 *
 * @author: zhangtian
 * @since: 2022-03-28 16:33
 */
@Data
public class FileUploadDto {
    private String secretId;

    private String secretKey;

    private String sessionToken;

    private String key;

    private String bucket;

    private String region;
}
