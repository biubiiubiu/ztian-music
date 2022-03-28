package com.example.ztianmusic.entity;

import com.example.ztianmusic.enums.MusicStatus;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

/**
 * description: 音乐实体类
 *
 * @author: zhangtian
 * @since: 2022-03-28 16:20
 */
@Entity
@Data
public class Music extends AbstractEntity {
    private String name;

    @Enumerated(EnumType.STRING)
    private MusicStatus status;

    private String description;
}