package com.example.ztianmusic.dto;

import lombok.Data;

import java.util.Date;

/**
 * description:
 *
 * @author: zhangtian
 * @since: 2022-03-30 09:34
 */
@Data
public abstract class BaseDto {
    private String id;

    private Date createdTime;

    private Date updatedTime;
}

