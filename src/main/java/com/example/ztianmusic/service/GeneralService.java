package com.example.ztianmusic.service;

import com.example.ztianmusic.dto.BaseDto;
import com.example.ztianmusic.entity.BaseEntity;
import com.example.ztianmusic.exception.ExceptionType;
import com.example.ztianmusic.mapper.MapperInterface;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * description:
 *
 * @author: zhangtian
 * @since: 2022-03-30 10:49
 */
public interface GeneralService<Entity extends BaseEntity, Dto extends BaseDto> {
    JpaRepository<Entity, String> getRepository();

    MapperInterface<Entity, Dto> getMapper();

    ExceptionType getNotFoundExceptionType();

    Dto create(Dto dto);

    Dto get(String id);

    Dto update(String id, Dto dto);

    void delete(String id);
}

