package com.example.ztianmusic.dto;

import com.example.ztianmusic.enums.Storage;
import lombok.Data;

/**
 * description:
 *
 * @author: zhangtian
 * @since: 2022-03-28 16:58
 */
@Data
public class SiteSettingDto {
    private String bucket;

    private String region;

    private Storage storage;
}
