package com.example.ztianmusic.mapper;

import com.example.ztianmusic.dto.ArtistCreateRequest;
import com.example.ztianmusic.dto.ArtistDto;
import com.example.ztianmusic.dto.ArtistUpdateRequest;
import com.example.ztianmusic.entity.Artist;
import com.example.ztianmusic.vo.ArtistVo;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.NullValuePropertyMappingStrategy;

/**
 * description:
 *
 * @author: zhangtian
 * @since: 2022-03-30 09:36
 */
@Mapper(componentModel = "spring", uses = {FileMapper.class, MusicMapper.class}, nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS,
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface ArtistMapper extends MapperInterface<Artist, ArtistDto> {

    @Mapping(source = "photoId", target = "photo.id")
    ArtistDto toDto(ArtistCreateRequest artistCreateRequest);

    ArtistDto toDto(ArtistUpdateRequest artistUpdateRequest);

    ArtistVo toVo(ArtistDto artistDto);
}
