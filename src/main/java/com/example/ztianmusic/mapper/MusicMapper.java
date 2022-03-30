package com.example.ztianmusic.mapper;

import com.example.ztianmusic.dto.MusicCreateRequest;
import com.example.ztianmusic.dto.MusicDto;
import com.example.ztianmusic.dto.MusicUpdateRequest;
import com.example.ztianmusic.entity.Music;
import com.example.ztianmusic.vo.MusicVo;
import org.mapstruct.Mapper;

/**
 * description: musicmapper
 *
 * @author: zhangtian
 * @since: 2022-03-28 16:17
 */
@Mapper(componentModel = "spring", uses = FileMapper.class)
public interface MusicMapper extends MapperInterface<Music, MusicDto> {
    MusicDto toDto(MusicCreateRequest musicCreateRequest);

    MusicDto toDto(MusicUpdateRequest musicUpdateRequest);

    MusicVo toVo(MusicDto musicDto);
}
