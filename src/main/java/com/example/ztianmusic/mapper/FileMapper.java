package com.example.ztianmusic.mapper;

import com.example.ztianmusic.dto.FileUploadRequest;
import com.example.ztianmusic.entity.File;
import org.mapstruct.Mapper;

/**
 * description: 文件mapper
 *
 * @author: zhangtian
 * @since: 2022-03-28 16:34
 */
@Mapper(componentModel = "spring")
public interface FileMapper {
    File createEntity(FileUploadRequest fileUploadRequest);
}