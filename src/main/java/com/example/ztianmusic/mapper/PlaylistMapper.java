package com.example.ztianmusic.mapper;

import com.example.ztianmusic.dto.PlaylistCreateRequest;
import com.example.ztianmusic.dto.PlaylistDto;
import com.example.ztianmusic.entity.Playlist;
import com.example.ztianmusic.vo.PlaylistVo;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.NullValuePropertyMappingStrategy;

/**
 * description:
 *
 * @author: zhangtian
 * @since: 2022-03-29 20:50
 */
@Mapper(componentModel = "spring", uses = {FileMapper.class}, nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS,
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface PlaylistMapper extends MapperInterface<Playlist, PlaylistDto> {

    @Mapping(source = "coverId", target = "cover.id")
    PlaylistDto toDto(PlaylistCreateRequest playlistCreateRequest);

    PlaylistVo toVo(PlaylistDto playlistDto);
}
