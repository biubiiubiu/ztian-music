package com.example.ztianmusic.dto;

import com.example.ztianmusic.enums.ArtistStatus;
import lombok.Data;

import java.util.List;

/**
 * description:
 *
 * @author: zhangtian
 * @since: 2022-03-30 09:35
 */
@Data
public class ArtistDto extends BaseDto {
    private String name;

    private String remark;

    private FileDto photo;

    private List<MusicDto> musicDtoList;

    private ArtistStatus status;
}