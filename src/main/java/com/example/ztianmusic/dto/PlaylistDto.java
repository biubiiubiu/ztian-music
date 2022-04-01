package com.example.ztianmusic.dto;

import com.example.ztianmusic.enums.PlayListStatus;
import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * description:
 *
 * @author: zhangtian
 * @since: 2022-03-29 20:47
 */
@Data
public class PlaylistDto extends TraceableBaseDto {

    private String name;

    private String description;

    private FileDto cover;

    private PlayListStatus status;

    private List<MusicDto> musicList;

    private Boolean recommended;

    private Integer recommendFactor;

    private Boolean special;
}