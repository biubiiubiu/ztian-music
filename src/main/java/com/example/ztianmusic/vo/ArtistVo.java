package com.example.ztianmusic.vo;

import com.example.ztianmusic.enums.ArtistStatus;
import lombok.Data;

import java.util.List;

/**
 * description:
 *
 * @author: zhangtian
 * @since: 2022-03-30 09:37
 */
@Data
public class ArtistVo extends BaseVo {
    private String name;

    private String remark;

    private FileVo photo;

    private List<MusicVo> musicDtoList;

    private ArtistStatus status;
}
