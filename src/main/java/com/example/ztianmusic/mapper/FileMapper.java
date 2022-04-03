package com.example.ztianmusic.mapper;

import com.example.ztianmusic.dto.FileDto;
import com.example.ztianmusic.dto.FileUploadRequest;
import com.example.ztianmusic.entity.File;
import com.example.ztianmusic.vo.FileVo;
import org.mapstruct.DecoratedWith;
import org.mapstruct.Mapper;

/**
 * description: 文件mapper
 *
 * @author: zhangtian
 * @since: 2022-03-28 16:34
 */
@Mapper(componentModel = "spring")
@DecoratedWith(FileMapperDecorator.class)
public interface FileMapper {
    File createEntity(FileUploadRequest fileUploadRequest);

    FileVo toVo(FileDto fileDto);

    FileDto toDto(File file);
}
