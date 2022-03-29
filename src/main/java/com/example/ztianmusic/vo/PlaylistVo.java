package com.example.ztianmusic.vo;

import com.example.ztianmusic.enums.PlayListStatus;
import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * description:
 *
 * @author: zhangtian
 * @since: 2022-03-29 20:50
 */
@Data
public class PlaylistVo extends BaseVo {
    private String id;

    private String name;

    private String description;

    private FileVo cover;

    private PlayListStatus status;

    private UserVo creator;

    private List<MusicVo> musicList;

    private Date createdTime;

    private Date updatedTime;
}

