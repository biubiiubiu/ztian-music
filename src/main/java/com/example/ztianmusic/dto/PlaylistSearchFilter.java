package com.example.ztianmusic.dto;

import lombok.Data;

/**
 * description:
 *
 * @author: zhangtian
 * @since: 2022-04-01 22:29
 */
@Data
public class PlaylistSearchFilter extends BaseSearchFilter {
    private String name = "";

    private Boolean recommended;
}
