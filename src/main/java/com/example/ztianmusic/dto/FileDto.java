package com.example.ztianmusic.dto;

import com.example.ztianmusic.enums.FileStatus;
import com.example.ztianmusic.enums.FileType;
import com.example.ztianmusic.enums.Storage;
import lombok.Data;

import java.util.Date;

/**
 * description: 文件dto
 *
 * @author: zhangtian
 * @since: 2022-03-28 16:32
 */
@Data
public class FileDto {
    private String id;

    private String name;

    private String key;

    private String ext;

    private Integer size;

    private FileType type;

    private Storage storage;

    private FileStatus status;

    private Date createdTime;

    private Date updatedTime;
}
