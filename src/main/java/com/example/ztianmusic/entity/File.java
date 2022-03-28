package com.example.ztianmusic.entity;

import com.example.ztianmusic.enums.FileStatus;
import com.example.ztianmusic.enums.FileType;
import com.example.ztianmusic.enums.Storage;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

/**
 * description: 文件实体类
 *
 * @author: zhangtian
 * @since: 2022-03-28 16:30
 */
@Entity
@Data
public class File extends AbstractEntity {
    private String name;

    private String key;

    private String ext;

    private Integer size;

    @Enumerated(EnumType.STRING)
    private FileType type;

    @Enumerated(EnumType.STRING)
    private Storage storage;

    @Enumerated(EnumType.STRING)
    private FileStatus status = FileStatus.UPLOADING;
}
