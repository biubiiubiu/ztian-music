package com.example.ztianmusic.dto;

import lombok.Data;

/**
 * description:
 *
 * @author: zhangtian
 * @since: 2022-03-30 20:08
 */
@Data
public class ArtistSearchFilter extends BaseSearchFilter {
    private String name = "";

    private Boolean recommended;
}

