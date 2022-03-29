package com.example.ztianmusic.mapper;

import com.example.ztianmusic.dto.PlaylistDto;
import com.example.ztianmusic.entity.Playlist;
import com.example.ztianmusic.vo.PlaylistVo;
import org.mapstruct.Mapper;

/**
 * description:
 *
 * @author: zhangtian
 * @since: 2022-03-29 20:50
 */
@Mapper(componentModel = "spring")
public interface PlaylistMapper {
    PlaylistDto toDto(Playlist playlist);

    PlaylistVo toVo(PlaylistDto playlistDto);
}
