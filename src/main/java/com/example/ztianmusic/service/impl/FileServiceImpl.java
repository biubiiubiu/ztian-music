package com.example.ztianmusic.service.impl;

import com.example.ztianmusic.dto.FileUploadDto;
import com.example.ztianmusic.dto.FileUploadRequest;
import com.example.ztianmusic.entity.File;
import com.example.ztianmusic.enums.Storage;
import com.example.ztianmusic.mapper.FileMapper;
import com.example.ztianmusic.repository.FileRepository;
import com.example.ztianmusic.service.FileService;
import com.example.ztianmusic.service.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

/**
 * description:
 *
 * @author: zhangtian
 * @since: 2022-03-28 16:38
 */
@Service
public class FileServiceImpl implements FileService {

    private Map<String, StorageService> storageServices;

    private FileRepository repository;

    private FileMapper fileMapper;

    @Override
    @Transactional
    public FileUploadDto initUpload(FileUploadRequest fileUploadRequest) {
        // 创建File实体
        File file = repository.save(fileMapper.createEntity(fileUploadRequest));

        // 通过接口获取STS令牌
        FileUploadDto fileUploadDto = storageServices.get(getDefaultStorage().name()).initFileUpload();

        fileUploadDto.setKey(file.getKey());
        return fileUploadDto;
    }


    // Todo: 后台设置当前Storage
    private Storage getDefaultStorage() {
        return Storage.COS;
    }


    @Autowired
    public void setStorageServices(Map<String, StorageService> storageServices) {
        this.storageServices = storageServices;
    }

    @Autowired
    public void setRepository(FileRepository repository) {
        this.repository = repository;
    }

    @Autowired
    public void setFileMapper(FileMapper fileMapper) {
        this.fileMapper = fileMapper;
    }
}

