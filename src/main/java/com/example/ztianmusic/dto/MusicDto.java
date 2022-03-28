package com.example.ztianmusic.dto;

import com.example.ztianmusic.enums.MusicStatus;
import lombok.Data;

import java.util.Date;

/**
 * description: music dto
 *
 * @author: zhangtian
 * @since: 2022-03-28 16:21
 */
@Data
public class MusicDto {
    private String id;

    private String name;

    private MusicStatus status;

    private String description;

    private Date createdTime;

    private Date updatedTime;
}