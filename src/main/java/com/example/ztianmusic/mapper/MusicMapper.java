package com.example.ztianmusic.mapper;

import com.example.ztianmusic.dto.MusicCreateRequest;
import com.example.ztianmusic.dto.MusicDto;
import com.example.ztianmusic.dto.MusicUpdateRequest;
import com.example.ztianmusic.entity.Music;
import com.example.ztianmusic.vo.MusicVo;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

/**
 * description: musicmapper
 *
 * @author: zhangtian
 * @since: 2022-03-28 16:17
 */
@Mapper(componentModel = "spring", uses = FileMapper.class)
public interface MusicMapper {
    MusicDto toDto(Music music);

    MusicVo toVo(MusicDto musicDto);

    Music createEntity(MusicCreateRequest musicCreateRequest);

    Music updateEntity(@MappingTarget Music music, MusicUpdateRequest musicUpdateRequest);
}
