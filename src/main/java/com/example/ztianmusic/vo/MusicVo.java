package com.example.ztianmusic.vo;

import com.example.ztianmusic.enums.MusicStatus;
import lombok.Data;

import java.util.List;

/**
 * description: music values object
 *
 * @author: zhangtian
 * @since: 2022-03-28 16:15
 */
@Data
public class MusicVo extends BaseVo {

    private String name;

    private MusicStatus status;

    private String description;

    private FileVo file;

    private List<ArtistVo> artistList;
}