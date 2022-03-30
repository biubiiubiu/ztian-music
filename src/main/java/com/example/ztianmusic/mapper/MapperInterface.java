package com.example.ztianmusic.mapper;

import com.example.ztianmusic.dto.BaseDto;
import com.example.ztianmusic.entity.BaseEntity;
import org.mapstruct.MappingTarget;

/**
 * description:
 *
 * @author: zhangtian
 * @since: 2022-03-30 10:47
 */
public interface MapperInterface<Entity extends BaseEntity, Dto extends BaseDto> {
    Dto toDto(Entity entity);

    Entity toEntity(Dto dto);

    Entity updateEntity(@MappingTarget Entity entity, Dto dto);
}
