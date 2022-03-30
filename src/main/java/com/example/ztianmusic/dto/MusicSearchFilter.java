package com.example.ztianmusic.dto;

import lombok.Data;

/**
 * description:
 *
 * @author: zhangtian
 * @since: 2022-03-30 20:00
 */
@Data
public class MusicSearchFilter {
    private String name = "";

    private Integer page = 1;

    private Integer size = 10;
}
