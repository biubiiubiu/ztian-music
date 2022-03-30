package com.example.ztianmusic.vo;

import com.example.ztianmusic.enums.FileStatus;
import com.example.ztianmusic.enums.FileType;
import com.example.ztianmusic.enums.Storage;
import lombok.Data;

/**
 * description:
 *
 * @author: zhangtian
 * @since: 2022-03-28 16:46
 */
@Data
public class FileVo extends BaseVo {
    private String name;

    private String key;

    private String uri;

    private Storage storage;

    private String ext;

    private Long size;

    private FileType type;

    private FileStatus status;
}

