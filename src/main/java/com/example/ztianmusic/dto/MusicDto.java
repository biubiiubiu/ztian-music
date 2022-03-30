package com.example.ztianmusic.dto;

import com.example.ztianmusic.enums.MusicStatus;
import lombok.Data;
import lombok.ToString;

import java.util.List;

/**
 * description: music dto
 *
 * @author: zhangtian
 * @since: 2022-03-28 16:21
 */
@Data
@ToString(callSuper = true)
public class MusicDto extends BaseDto {
    private String name;

    private MusicStatus status = MusicStatus.DRAFT;

    private String description;

    private FileDto file;

    private List<ArtistDto> artistList;
}
