package com.example.ztianmusic.mapper;

import com.example.ztianmusic.dto.ArtistCreateRequest;
import com.example.ztianmusic.dto.ArtistDto;
import com.example.ztianmusic.dto.ArtistUpdateRequest;
import com.example.ztianmusic.entity.Artist;
import com.example.ztianmusic.vo.ArtistVo;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

/**
 * description:
 *
 * @author: zhangtian
 * @since: 2022-03-30 09:36
 */
@Mapper(componentModel = "spring", uses = {FileMapper.class, MusicMapper.class})
public interface ArtistMapper {

    @Mapping(source = "photoId", target = "photo.id")
    Artist createEntity(ArtistCreateRequest artistCreateRequest);

    @Mapping(source = "photoId", target = "photo.id")
    Artist updateEntity(@MappingTarget Artist artist, ArtistUpdateRequest artistUpdateRequest);

    ArtistDto toDto(Artist artist);

    ArtistVo toVo(ArtistDto artistDto);
}
