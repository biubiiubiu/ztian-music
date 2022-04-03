package com.example.ztianmusic.vo;

import com.example.ztianmusic.enums.Storage;
import lombok.Data;

/**
 * description:
 *
 * @author: zhangtian
 * @since: 2022-03-28 16:56
 */
@Data
public class SiteSettingVo {
    private String bucket;

    private String region;

    private Storage storage;
}
