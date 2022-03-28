package com.example.ztianmusic.mapper;

import com.example.ztianmusic.dto.FileUploadDto;
import com.example.ztianmusic.vo.FileUploadVo;
import org.mapstruct.Mapper;

/**
 * description: 文件上传mapper
 *
 * @author: zhangtian
 * @since: 2022-03-28 16:35
 */
@Mapper(componentModel = "spring")
public interface FileUploadMapper {
    FileUploadVo toVo(FileUploadDto fileUploadDto);
}
