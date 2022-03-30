package com.example.ztianmusic.mapper;

import com.example.ztianmusic.dto.FileDto;
import com.example.ztianmusic.entity.File;
import com.example.ztianmusic.service.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.Map;

/**
 * description:文件uri转换器
 *
 * @author: zhangtian
 * @since: 2022-03-30 08:48
 */
public abstract class FileMapperDecorator implements FileMapper {

    @Autowired
    @Qualifier("delegate")
    private FileMapper delegate;

    @Autowired
    private Map<String, StorageService> storageServices;

    @Override
    public FileDto toDto(File file) {
        FileDto fileDto = delegate.toDto(file);

        if (fileDto == null) {
            return null;
        }
        if (fileDto.getStorage() == null) {
            return null;
        }
        fileDto.setUri(storageServices.get(fileDto.getStorage().name()).getFileUri(fileDto.getKey()));
        return fileDto;
    }
}
