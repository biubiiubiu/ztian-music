package com.example.ztianmusic.vo;

import lombok.Data;

/**
 * description:
 *
 * @author: zhangtian
 * @since: 2022-03-28 16:36
 */
@Data
public class FileUploadVo {
    private String secretId;

    private String secretKey;

    private String sessionToken;

    private String key;

    private String fileId;

    private Long startTime;

    private Long expiredTime;
}
